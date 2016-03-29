package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MyClassPrompt {
    public static void main(String[] args) {
        Class c;
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.print("The name of the class: ");
            String aclass = sc.next();
            c = Class.forName(aclass);
            System.out.println(c.getName());
            System.out.println(c.getSimpleName());
            System.out.println(c.isInterface());
            Method[] f = c.getMethods();
            for (Method x : f) {
                System.out.println(x);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}