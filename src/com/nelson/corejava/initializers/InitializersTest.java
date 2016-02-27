package com.nelson.corejava.initializers;

public class InitializersTest {

    public InitializersTest() {
        System.out.print("say... ");
    }

    {
        System.out.print("who ");
    }

    static {
        System.out.print("We ");
    }

    public static void main(String[] args) throws Exception {

        System.out.print("are ");
        new InitializersTest();
        {
            System.out.print("Ni. ");
        }
    }

    {
        System.out.print("the ");
    }

    {
        System.out.print("Knights ");
    }

}
