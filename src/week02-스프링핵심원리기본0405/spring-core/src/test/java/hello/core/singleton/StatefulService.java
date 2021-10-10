package hello.core.singleton;

public class StatefulService {

    /* State를 유지  */
//    private int price;        // 필드: 상태를 유지해버림
//
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;   // 문제의 상태
//    }
//
//    public int getPrice() {
//        return price;
//    }

    /* State를 유지하지 않음  */
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;           // 해결책
    }

}
