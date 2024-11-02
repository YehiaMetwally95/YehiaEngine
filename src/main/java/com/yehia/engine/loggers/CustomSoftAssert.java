package com.yehia.engine.loggers;

import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static com.yehia.engine.driverManager.BrowserFactory.getDriver;

public class CustomSoftAssert extends SoftAssert{

    public static CustomSoftAssert softAssert = new CustomSoftAssert();
    // Use ThreadLocal to store errors separately for each test thread
    private static final ThreadLocal<List<String>> errors = ThreadLocal.withInitial(ArrayList::new);

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        ITestResult result = Reporter.getCurrentTestResult();
        ITestContext context = result.getTestContext();
        ThreadLocal<RemoteWebDriver> driver = (ThreadLocal<RemoteWebDriver>) context.getAttribute("isolatedDriver");

        String errorMessage = "Soft Assertion Failed: " + ex.getMessage();
        Screenshot.captureSoftFailure(getDriver(driver),assertCommand,errorMessage);
        errors.get().add(errorMessage); // Add error to the ThreadLocal list for this thread
    }

    public static void reportSoftAssertionErrors(IInvokedMethod method) {
        try {
            List<String> threadErrors = errors.get();  // Get the thread-local errors list
            if (!threadErrors.isEmpty()) {
                String combinedError = String.join("\n", threadErrors);
                LogHelper.logWarningStep("Soft Assertions Summary:\n" + combinedError);
                Allure.step("Soft Assertions Summary for " + method.getTestMethod().getMethodName() + ": \n", () -> {
                    threadErrors.forEach(Allure::step);
                });
            }
        } catch (Exception e) {
            LogHelper.logErrorStep("Failed to Log the Soft Assertion Summery Report", e);
        } finally {
            errors.remove();  // Clear the ThreadLocal list after reporting
        }
    }
}
