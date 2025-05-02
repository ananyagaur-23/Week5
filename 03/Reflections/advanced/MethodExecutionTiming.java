package advanced;
import java.lang.reflect.Method;

class MyClass {
    public void slowMethod() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Method executed");
    }

    public void fastMethod() {
        System.out.println("Fast method executed");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        Method slowMethod = MyClass.class.getMethod("slowMethod");
        Method fastMethod = MyClass.class.getMethod("fastMethod");

        long startTime = System.nanoTime();
        slowMethod.invoke(myClass);
        long endTime = System.nanoTime();
        System.out.println("Execution time for slowMethod: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        fastMethod.invoke(myClass);
        endTime = System.nanoTime();
        System.out.println("Execution time for fastMethod: " + (endTime - startTime) + " nanoseconds");
    }
}
