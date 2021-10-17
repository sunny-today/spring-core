package hello.core;

import hello.core.HelloWorld;

public class Dummy {

    private String name;

    @HelloWorld
    public String getName() {
        return this.name;
    }

    public static void main(String... args) {
        new Dummy().getName();
    }
}