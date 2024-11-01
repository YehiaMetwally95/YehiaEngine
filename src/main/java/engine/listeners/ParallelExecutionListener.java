package engine.listeners;

import engine.managers.PropertiesManager;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;

import static engine.loggers.LogHelper.logErrorStep;
import static engine.loggers.LogHelper.logInfoStep;

public class ParallelExecutionListener implements IAlterSuiteListener {


    public void alter (List<XmlSuite> suites) {
        //Load Properties File
        PropertiesManager.loadProperties();

        //Configure Parallel mode and thread count
        try {
            String parallel_Mode = System.getProperty("parallelMode");
            String thread_count = System.getProperty("threadCount");

            for (XmlSuite suite : suites) {
                suite.setParallel(XmlSuite.ParallelMode.valueOf(parallel_Mode.toUpperCase()));
                suite.setThreadCount(Integer.parseInt(thread_count));
            }
            logInfoStep("Running Tests with Parallel Mode = ["+parallel_Mode+"]");
            if (!parallel_Mode.equalsIgnoreCase("None"))
                logInfoStep("Thread Count = ["+thread_count+"]");

        }catch (Exception e){
            logErrorStep("Failed to Run Tests, Please Check Value of Parallel Mode or Thread Count",e);
        }
    }
}
