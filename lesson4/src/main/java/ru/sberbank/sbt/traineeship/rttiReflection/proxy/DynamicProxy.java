package ru.sberbank.sbt.traineeship.rttiReflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by SBT-Aleksandrov-SA on 07.04.2016.
 */
public class DynamicProxy implements InvocationHandler{

        private Object target;

        public DynamicProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Method '" + method.getName() + "' invocation.");
            return method.invoke(target, args);
        }
}
