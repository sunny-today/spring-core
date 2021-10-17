package hello.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTestInvocationHandler implements InvocationHandler {

    private Object proxyImpl;

    public ProxyTestInvocationHandler(Object proxyImpl) {
        this.proxyImpl = proxyImpl;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Start Proxy-Class");
        String newVal = method.invoke(proxyImpl, objects) + "!";
        System.out.println("End Proxy-Class");
        return new String(newVal);
    }
}
