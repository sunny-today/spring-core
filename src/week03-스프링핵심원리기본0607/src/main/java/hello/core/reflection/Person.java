package hello.core.reflection;

import hello.core.HelloWorld;
import hello.core.annotation.MainDiscountPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@MainDiscountPolicy
public class Person {
    private String name;
    private int age;

    @MainDiscountPolicy
    public String process() {
        return "success";
    }
}
