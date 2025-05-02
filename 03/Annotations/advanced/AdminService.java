package advanced;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

public class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted.");
    }

    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; 
        AdminService service = new AdminService();
        Method method = service.getClass().getMethod("deleteUser");

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(currentUserRole)) {
                method.invoke(service);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
