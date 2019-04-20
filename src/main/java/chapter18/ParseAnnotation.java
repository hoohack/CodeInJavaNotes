package chapter18;

import java.lang.reflect.Method;

public class ParseAnnotation {

    public void parseMethod(final Class<?> clazz) throws Exception {
        final Object obj = clazz.getConstructor(new Class[] {}).newInstance(new Object[] {});
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods) {
            final ClientAdded clientAdded = method.getAnnotation(ClientAdded.class);
            if (null != clientAdded) {
                method.invoke(obj);
            }

            final ClientRemoved clientRemoved = method.getAnnotation(ClientRemoved.class);
            if (null != clientRemoved) {
                method.invoke(obj);
            }
        }
    }

}
