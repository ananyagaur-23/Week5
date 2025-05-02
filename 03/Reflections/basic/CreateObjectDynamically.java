package basic;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CreateObjectDynamically {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("Student");
        Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);
        Object studentObject = constructor.newInstance("John Doe", 20);
        Student student = (Student) studentObject;
        student.display();
    }
}
