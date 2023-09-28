package FrameworkTop;

import org.testng.TestNG;
import FrameworkTop.utils.GlobalParams;
import FrameworkTop.utils.PropertyManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws IOException {
        List<String> testFilesList = new ArrayList<>();
        testFilesList.add("testng.xml");
        TestNG testng = new TestNG();
        testng.setTestSuites(testFilesList);
        testng.run();

    }
}
