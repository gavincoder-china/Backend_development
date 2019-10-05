package jdk8.defaultmethod;


public class MyClass extends MyInterface1Impl implements MyInterface2{

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
