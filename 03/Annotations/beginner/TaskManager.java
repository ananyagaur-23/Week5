package beginner;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

public class TaskManager {

    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Performing critical task.");
    }

    @ImportantMethod(level = "LOW")
    public void regularTask() {
        System.out.println("Performing regular task.");
    }

    public static void main(String[] args) throws Exception {
       
        TaskManager manager = new TaskManager();
        Method[] methods = manager.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}
