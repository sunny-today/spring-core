package hello.core.singleton;

/**
 * 스프링을 사용하지 않고 싱글턴 패턴을 사용하기 위해 사용
 */
public class SingletonService {

    // static: Class 레벨에 올라가기 떄문에 인스턴스가 1개만 생성이 된다.
    private static final SingletonService instance = new SingletonService();

    // instance를 꺼내어 사용할 수 있도록하는 유일한 메소드
    public static SingletonService getInstance() {
        return instance;
    }

    // private: new 키워드로 객체 인스턴스가 생성되는 것을 방지한다.
    // But. private 생성자로 자식 클래스를 만들기 어렵다.
    private SingletonService() {

    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
