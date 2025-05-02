package exercise;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}


public class E5 {
    
    @BugReport(description = "Bug in login feature")
    @BugReport(description = "UI issue on dashboard")
    public void fixBugs() {
        System.out.println("Fixing bugs...");
        }
    
    public static void main(String[] args) throws Exception {
        E5 manager = new E5();
        Method method = manager.getClass().getMethod("fixBugs");
        
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug Report: " + bugReport.description());
            }
        }
    }
}
