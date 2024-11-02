package com.yehia.engine.listeners;

import com.yehia.engine.loggers.AllureReportLogger;
import com.yehia.engine.utilities.DeleteDirectoryFiles;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;

public class SuiteListeners implements ISuiteListener {

    public void onStart (ISuite suite) {

        //Clear Old Screenshots & Allure Results before Every Run
        File file1 = new File("src/main/resources/screenshots");
        File file2 = new File("target/allure-results");
        DeleteDirectoryFiles.deleteFiles(file1);
        DeleteDirectoryFiles.deleteFiles(file2);
    }

    public void onFinish (ISuite suite) {
        //Genarate the Allure Report after Suite Run
        AllureReportLogger.generateAllureReport();
    }

}
