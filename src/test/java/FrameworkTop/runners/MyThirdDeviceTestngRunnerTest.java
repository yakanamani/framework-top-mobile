package FrameworkTop.runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {
        "pretty",
        "html:test-output/reports/cucumber/third_device/report.html",
        "junit:test-output/reports/cucumber/third_device/report.xml",
        "json:test-output/reports/cucumber/third_device/report.json",
        "summary",
},
        features = {"src/test/resources"},
        glue = "FrameworkTop.stepdef",
        tags = "@test",
        monochrome = false
)
public class MyThirdDeviceTestngRunnerTest extends RunnerBase{


}
