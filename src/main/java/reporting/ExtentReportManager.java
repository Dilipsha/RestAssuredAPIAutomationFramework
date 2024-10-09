package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    public static ExtentReports extentReports;

    public static ExtentReports createInstance(String fileName,String reportName,String documentTitle){
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return  extentReports;
    }

    public static String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("DD/MM/YYYY : HH:MM:SS");
        LocalDateTime localDateTime=LocalDateTime.now();
        String formattedTime=dateTimeFormatter.format(localDateTime);
        String reportName="Test Report " + formattedTime + ".html";
        return reportName;
    }
}
