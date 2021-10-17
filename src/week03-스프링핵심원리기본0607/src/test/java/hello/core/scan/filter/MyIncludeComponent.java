package hello.core.scan.filter;

import java.lang.annotation.*;

//TYPE : 클래스 LEVEL에 붙음
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
