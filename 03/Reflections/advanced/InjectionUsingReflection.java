package advanced;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class DatabaseService {
    public void connect() {
        System.out.println("Connected to Database.");
    }
}

class UserService {
    @Inject
    private DatabaseService databaseService;

    public void performAction() {
        databaseService.connect();
        System.out.println("User action performed.");
    }
}

class DIContainer {
    public static void injectDependencies(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(object, dependency);
            }
        }
    }
}

public class InjectionUsingReflection{
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        DIContainer.injectDependencies(userService);
        userService.performAction();
    }
}
