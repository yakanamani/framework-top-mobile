package FrameworkTop.runners;


import io.cucumber.testng.*;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;
import FrameworkTop.utils.DriverManager;
import FrameworkTop.utils.GlobalParams;
import FrameworkTop.utils.ServerManager;

@CucumberOptions(plugin = {
        "pretty",
        "html:reports/cucumber/report.html",
        "summary",
        "junit:reports/cucumber/j-unit_report.html"
        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
        features = {"src/test/resources"},
        glue = "FrameworkTop.stepdef",
        tags = "@test",
        monochrome = false
)
public class MytestngRunnerTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"platformName", "udid", "deviceName", "systemPort", "chromeDriverPort",
            "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context, String platformName, String udid, String deviceName,
                           @Optional("Android") String systemPort,
                           @Optional("Android") String chromeDriverPort,
                           @Optional("iOS")String wdaLocalPort,
                           @Optional("iOS")String webkitDebugProxyPort)
    {
        ThreadContext.put("ROUTINGKEY", platformName + "_"
                + deviceName);
        GlobalParams params = new GlobalParams();
        params.setPlatformName(platformName);
        params.setUDID(udid);
        params.setDeviceName(deviceName);

        switch (platformName){
            case "Android":
                params.setSystemPort(systemPort);
                params.setChromeDriverPort(chromeDriverPort);
                break;
            case "iOS":
                params.setWdaLocalPort(wdaLocalPort);
                params.setWebkitDebugProxyPort(webkitDebugProxyPort);
                break;
        }

        new ServerManager().startServer();
        new DriverManager().initializeDriver();

        XmlTest currentXmlTest = context.getCurrentXmlTest();
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        DriverManager driverManager =new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);

        }
        ServerManager serverManager =new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();

        }
        if (testNGCucumberRunner != null) {
            testNGCucumberRunner.finish();

        }
    }

}
