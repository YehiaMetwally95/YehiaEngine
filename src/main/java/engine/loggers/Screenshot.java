package engine.loggers;

import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.asserts.IAssert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static engine.loggers.LogHelper.*;

public class Screenshot {

    public static void captureSuccess(WebDriver driver, ITestResult result){
            try {
                Thread.sleep(1000);
                File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destination = new File("src/main/resources/screenshots/SuccessfulTests/" + result.getMethod().getMethodName() + ".png");
                FileHandler.copy(source, destination);

                var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Successful Screenshot for [" + result.getMethod().getMethodName()+"]", new ByteArrayInputStream(screenshot));
                logInfoStep("Capturing Screenshot for Succeeded Scenario");
            }catch (Exception e)
            {
                logErrorStep("Failed to Capture Screenshot for Succeeded Scenario",e);
            }
    }

    public static void captureFailure(WebDriver driver, ITestResult result){
            try {
            Thread.sleep(1000);
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/main/resources/screenshots/FailedTests/"+ result.getMethod().getMethodName() +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot for ["+result.getMethod().getMethodName()+"]",new ByteArrayInputStream(screenshot));
                logInfoStep("Capturing Screenshot for Failed Scenario");
            }catch (Exception e)
            {
                logErrorStep("Failed to Capture Screenshot for Failed Scenario",e);
            }
    }

    public static void captureSoftFailure(WebDriver driver,IAssert<?> assertCommand,String error) throws IOException, InterruptedException {

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/main/resources/screenshots/SoftAssertionFailures/"+ assertCommand.getExpected() +".png");
            FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Soft Assertion Screenshot",new ByteArrayInputStream(screenshot));
            Allure.step(error);
            logWarningStep(error);
            logWarningStep("Capturing Screenshot for Soft Assertion Failure");
        }catch (Exception e)
        {
            logErrorStep("Failed to Capture Screenshot for Soft Assertion Failure",e);
        }
    }

    public static void takeElementScreenshot(WebDriver driver, By locator , String targetPath ,
                                             String fileName) throws IOException {
        try {
        File source = driver.findElement(locator).getScreenshotAs(OutputType.FILE);
        File destination = new File (targetPath+fileName+".png");
        FileHandler.copy(source,destination);
            logInfoStep("Capturing Screenshot for Element");
        }catch (Exception e)
        {
            logErrorStep("Failed to Capture Screenshot for Element",e);
        }
    }

    public static AllureRestAssured logApiRequestsToAllureReport(){
        return new AllureRestAssured()
                .setRequestAttachmentName("Request Details")
                .setResponseAttachmentName("Response Details");
    }
}

