package intermediate;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {}

public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) throws Exception {
        Class<?> bookClass = Book.class;
        if (bookClass.isAnnotationPresent(Author.class)) {
            Author authorAnnotation = bookClass.getAnnotation(Author.class);
            System.out.println("Author: " + authorAnnotation.name());
        }
    }
}
