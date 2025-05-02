package exercise;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

public class E4{
    
    @TaskInfo(priority = "High", assignedTo = "John")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }
    
    public static void main(String[] args) throws Exception {

        E4 manager = new E4();
        Method method = manager.getClass().getMethod("completeTask");
        
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
