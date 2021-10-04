package hello.core.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    /**
     * MVC와 템플릿 엔진
     * @param name
     * @param model
     * @return
     */
    @GetMapping("hello-mvc")    // 실행: http://localhost:8080/hello-mvc?name=spring
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
        // Model 은 화면을 랜더링 할때 사용함.
        model.addAttribute("name", name);
        return "hello-template";
    }

    /**
     * ResponseBody의 개념
     * @param name
     * @return
     */
    @GetMapping("hello-string")
    @ResponseBody   // http 에서 body 부에 이 데이터를 직접 넣어 주겠다는 의미.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 요청한 클라이언트에게 그대로 내려감(View 가 없음)
    }

    /**
     * 객체 전달 & json
     * @param name
     * @return
     */
    @GetMapping("hello-api")
    @ResponseBody   // json 반환이 기본
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체를 넘김
    }

    // 객체 생성 / 이 class 안에서 바로 사용하기 위해 static class로 생성
    static class Hello {
        private String name;

        // getter and setter
        // name private 이므로 해당 메서드를 통해 접근 (자바 빈 표준 방식, 프로퍼티 접근 방식)
        public String getName() {
            return name;
        }

        public Hello setName(String name) {
            this.name = name;
            return this;
        }
    }

}
