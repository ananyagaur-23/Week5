package exercise;

import java.util.ArrayList;

public class SuppressUncheckedWarnings{
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(123);
        System.out.println(list);
    }
}
