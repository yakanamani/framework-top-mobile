package FrameworkTop.runners;

import io.cucumber.testng.CucumberPropertiesProvider;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;
import FrameworkTop.utils.DriverManager;
import FrameworkTop.utils.GlobalParams;
import FrameworkTop.utils.PropertyManager;
import FrameworkTop.utils.ServerManager;

import java.io.IOException;
import java.util.Properties;

public class RunnerBase {
    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();
    public static TestNGCucumberRunner getRunner(){
        return testNGCucumberRunner.get();
    }
    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }
    @Parameters({"platformName", "udid", "deviceName", "virtualDevice", "systemPort", "chromeDriverPort",
            "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context, String platformName, String udid, String deviceName, String virtualDevice,
                           @Optional("Android") String systemPort,
                           @Optional("Android") String chromeDriverPort,
                           @Optional("iOS")String wdaLocalPort,
                           @Optional("iOS")String webkitDebugProxyPort) throws IOException {
        //Runtime.getRuntime().exec("rm -r test-output");
        ThreadContext.put("ROUTINGKEY", platformName + "_"
                + deviceName);
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();
        params.setPlatformName(platformName);
        params.setUDID(udid);
        params.setDeviceName(deviceName);
        params.setVirtualDevice(virtualDevice);

        switch (platformName){
            case "Android":
                params.setSystemPort(systemPort);
                params.setChromeDriverPort(chromeDriverPort);
                Runtime.getRuntime().exec("adb uninstall " + props.getProperty("androidAppPackage"));

                break;
            case "iOS":
                params.setWdaLocalPort(wdaLocalPort);
                params.setWebkitDebugProxyPort(webkitDebugProxyPort);
                if (params.getVirtualDevice().equalsIgnoreCase("true")){
                    Runtime.getRuntime().exec("xcrun simctl uninstall " + params.getUDID() + " " + props.getProperty("iOSBundleId"));
                } else if (params.getVirtualDevice().equalsIgnoreCase("false")) {
                    Runtime.getRuntime().exec("ideviceinstaller -U " + props.getProperty("iOSBundleId"));
                }
                break;
        }

        new ServerManager().startServer();
        new DriverManager().initializeDriver();

        XmlTest currentXmlTest = context.getCurrentXmlTest();
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        setRunner(new TestNGCucumberRunner(this.getClass(), properties));
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();
        DriverManager driverManager =new DriverManager();
        switch (params.getPlatformName()) {
            case "Android":
                Runtime.getRuntime().exec("adb uninstall " + props.getProperty("androidAppPackage"));
                break;
            case "iOS":
                Runtime.getRuntime().exec("xcrun simctl uninstall " + params.getUDID() + " " + props.getProperty("iOSBundleId"));
                break;
        }
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);

        }
        ServerManager serverManager =new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();

        }
        if (testNGCucumberRunner != null) {
            getRunner().finish();

        }
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        if (isWindows){
            Runtime.getRuntime().exec(String.format("cmd.exe /c allure generate --clean Test-output/reports/allure-results -o Test-output/reports/allure-report"));
        } else {
            Runtime.getRuntime().exec("allure generate --clean Test-output/reports/allure-results -o Test-output/reports/allure-report");
        }

    }
}
