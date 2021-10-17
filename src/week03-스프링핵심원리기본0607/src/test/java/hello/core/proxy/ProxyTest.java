package hello.core.proxy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    @Test
    void test() {
        Proxy proxy = (Proxy) java.lang.reflect.Proxy.newProxyInstance(
                Proxy.class.getClassLoader(),
                new Class[]{Proxy.class},
                new ProxyTestInvocationHandler(new ProxyImpl())
        );

        Assertions.assertThat(proxy.execute()).isEqualTo("success!");
        Assertions.assertThat(proxy.test()).isEqualTo("test!");
    }
}
