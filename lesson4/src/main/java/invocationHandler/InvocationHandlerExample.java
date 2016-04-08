package invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBT-Aleksandrov-SA on 07.04.2016.
 */
public class InvocationHandlerExample {

    private static final List<String> listOfStrings = new ArrayList<String>();
    static {
        listOfStrings.add("one");
        listOfStrings.add("two");
        listOfStrings.add("three");
    }

    public static class TestProxy implements InvocationHandler{

        private Object target;

        public TestProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Method has been invoked.");
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        List<String> proxiedList = (List<String>) Proxy.newProxyInstance(
                listOfStrings.getClass().getClassLoader(), new Class[] {List.class}, new TestProxy (listOfStrings)
        );

        System.out.println ("List size: " + proxiedList.size());
    }
}
