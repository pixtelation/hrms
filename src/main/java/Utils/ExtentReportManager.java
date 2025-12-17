package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(new Date());
            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport_" + timeStamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("HRMS Automation Report");
            spark.config().setDocumentTitle("HRMS Selenium Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "HRMS");
            extent.setSystemInfo("Tester", "Automation");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}
