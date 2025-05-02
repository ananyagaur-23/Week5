package advanced;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

public class ExpensiveCalculator {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) return cache.get(number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calculator = new ExpensiveCalculator();
        Method method = calculator.getClass().getMethod("computeSquare", int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(calculator.computeSquare(5));
            System.out.println(calculator.computeSquare(5));
            System.out.println(calculator.computeSquare(10));
            System.out.println(calculator.computeSquare(10));
        }
    }
}
