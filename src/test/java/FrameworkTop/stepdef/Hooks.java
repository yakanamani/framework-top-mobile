package FrameworkTop.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import FrameworkTop.utils.DriverManager;
import FrameworkTop.utils.VideoManager;

import java.io.IOException;

public class Hooks {
    @Before
    public void initialize(){

        new VideoManager().startRecording();

    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        new VideoManager().stopRecording(scenario.getName());


    }
}
