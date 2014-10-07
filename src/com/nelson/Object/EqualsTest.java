package com.nelson.Object;

/**
 * Created with IntelliJ IDEA.
 * User: tjnelson
 * Date: 8/28/13
 * Time: 1:26 PM
 */
public class EqualsTest {

    public static void main(String args[]) {
        Object obj1 = new Object();
        Object obj2 = new Object();

//        This is the Object equals method.
//        public boolean equals(Object obj) {
//            return (this == obj);
//        }

        if (obj1.equals(obj2)) {
            System.out.println("obj1.equals(obj2)");
        }
        if (obj1 == obj2) {
            System.out.println("obj1 == obj2");
        }

//        This is the String equals method.
//        public boolean equals(Object anObject) {
//            if (this == anObject) {
//                return true;
//            }
//            if (anObject instanceof String) {
//                String anotherString = (String) anObject;
//                int n = value.length;
//                if (n == anotherString.value.length) {
//                    char v1[] = value;
//                    char v2[] = anotherString.value;
//                    int i = 0;
//                    while (n-- != 0) {
//                        if (v1[i] != v2[i])
//                            return false;
//                        i++;
//                    }
//                    return true;
//                }
//            }
//            return false;
//        }

        String tom = "tom";
        String tom2 = "tom";

        if ((tom.equals(tom2))) {
            System.out.println("tom.equals(tom2)");
        }
        if (tom == tom2) {
            System.out.println("tom == tom2");
        }

        String tom3 = new String("tom");
        String tom4 = new String("tom");

        if (tom3.equals(tom4)) {
            System.out.println("tom3.equals(tom4)");
        }
        if (tom3 == tom4) {
            System.out.println("tom3 == tom4");
        }
    }
}
