package FrameworkTop.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;

public class ServerManager {


    private static final ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public static AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() {
        utils.log().info("starting appium server");
        AppiumDriverLocalService server = GetAppiumService();
        server.clearOutPutStreams();
        server.start();
        if (server == null || !server.isRunning()) {
            utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        //server.clearOutPutStreams();
        ServerManager.server.set(server);
        utils.log().info("appium server started");

    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }
    public AppiumDriverLocalService GetAppiumService() {
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withTimeout(Duration.ofSeconds(180))
                .withLogFile(new File("test-output" + File.separator + LocalDate.now() + File.separator
                        + params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "logs"
                        + File.separator + "Server.log")));

    }

    public AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + utils.dateTime() + File.separator + "Server.log")));
    }

    public AppiumDriverLocalService MacGetAppiumService() {
        GlobalParams params = new GlobalParams();
        //HashMap<String, String> environment = new HashMap<String, String>();
        //environment.put("PATH", "/Users/nana.acka/Library/Android/sdk/tools/bin:/Users/nana.acka/Library/Android/sdk/tools:/Users/nana.acka/Library/Android/sdk/platform-tools:/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home/bin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/MacGPG2/bin:/Library/Apple/usr/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/appleinternal/bin:/usr/local/nodejs/bin:/opt/homebrew/bin:/usr/local/bin:/opt/homebrew/bin/ffmpeg" + System.getenv("PATH"));
        //environment.put("ANDROID_HOME", "/Users/nana.acka/Library/Android/sdk");
        //environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                //.usingDriverExecutable(new File("/usr/local/bin/node"))
                //.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                //.withEnvironment(environment)
                .withLogFile(new File("test-output" + File.separator + LocalDate.now() + File.separator
                        + params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "logs"
                        + File.separator + "Server.log")));

    }
}
