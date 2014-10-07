package com.nelson.nio;

/**
 * Created with IntelliJ IDEA.
 * User: tjnelson
 * Date: 8/28/13
 * Time: 12:13 PM
 */
public class InitializersTest {

    public InitializersTest() {
        System.out.println("who ");
    }
    {
        System.out.println("say... ");
    }
    {
        System.out.println("Knights ");
    }
    static {
        System.out.println("We ");
    }

    public static void main(String[] args) throws Exception {

        System.out.println("are ");
        new InitializersTest();
    }
    {
        System.out.println("the ");
    }
}
