package beginner;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Class with methods annotated using @Todo
public class Projectmanager {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {}

    @Todo(task = "Refactor payment module", assignedTo = "Bob")
    public void paymentModule() {}

    @Todo(task = "Add logging", assignedTo = "Charlie", priority = "LOW")
    public void addLogging() {}

    public static void main(String[] args) throws Exception {
        Method[] methods = Projectmanager.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task: " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority: " + todo.priority());
            }
        }
    }
}
