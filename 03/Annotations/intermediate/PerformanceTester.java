package intermediate;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

public class PerformanceTester {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }

    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();
        Method[] methods = PerformanceTester.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Method: " + method.getName() + " took " + duration + " ns");
            }
        }
    }
}
