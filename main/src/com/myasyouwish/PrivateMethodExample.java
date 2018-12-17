package com.myasyouwish;

public interface PrivateMethodExample {

    Integer getInteger();

    public default void publicMethodInInterface() {
        privateMethodInInterface();
    }

    private void privateMethodInInterface(){
        System.out.println("I am in private interface method");
    }
}
