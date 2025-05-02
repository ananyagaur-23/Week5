package intermediate;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

public class User {
    
    @MaxLength(10)
    private String username;

    public User(String username) {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (field.getName().equals("username") && username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value());
                }
            }
        }
        this.username = username;
    }

    public static void main(String[] args) {
        User user1 = new User("Alice123");             
        User user2 = new User("ThisNameIsTooLong");  
    }
}
