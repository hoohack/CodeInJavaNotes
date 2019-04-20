package chapter17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用反射调用quack方法
 */
public class CallQuack {

    public static void main(String[] args) {
        String objName = args[0];

        try {
            Class<?> c = Class.forName(objName);

            Object obj = c.newInstance();

            Method m = c.getMethod("quack");

            m.invoke(obj);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
