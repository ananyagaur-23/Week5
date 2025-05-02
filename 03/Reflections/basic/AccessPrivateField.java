package basic;

import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(person, 30);
        int age = ageField.getInt(person);
        System.out.println(age);
    }
}
