package com.nelson.dpatterns.creational.prototype;

import java.util.Hashtable;

/**
 * The Prototype pattern is basically the creation of new instances through cloning existing instances. By Creating a
 * prototype, new objects are created by copying this prototype.
 * <p/>
 * Where to use:
 * <p/>
 * When a system needs to be independent of how its objects are created, composed and represented. When adding and
 * removing objects at runtime. When specifying new objects by changing and existing objects structure. When configuring
 * an application with classes dynamically. When trying to keep the number of classes in a system to a minimum. When
 * State population is an expensive or exclusive process.
 * <p/>
 * Benefits:
 * <p/>
 * Speeds up instantiation of large, dynamically loaded classes. Reduced sub-classing.
 * <p/>
 * Drawbacks:
 * <p/>
 * Each subclass of Prototype must implement the Clone operation. Could be difficult with existing classes with internal
 * objects with circular references or which does not support copying.
 * <p/>
 * Usage:
 * <p/>
 * If you are designing a system for performing back account transactions, then you would want to make a copy of the
 * Object which holds your account information, perform transactions on it, and then replace the original Object with
 * the modified one. In such cases, you would want to use clone() instead of new.
 *
 * @author trnelson
 */
public class TestPrototype {

    Hashtable<String, Product> productMap = new Hashtable<String, Product>();

    public static void main(String[] args) {

        TestPrototype testPrototype = new TestPrototype();
        testPrototype.loadCache();

        Book clonedBook = (Book) testPrototype.getProduct("B1");
        System.out.println("SKU = " + clonedBook.getSKU());
        System.out.println("SKU = " + clonedBook.getDescription());
        System.out.println("SKU = " + clonedBook.getNumberOfPages());

        DVD clonedDVD = (DVD) testPrototype.getProduct("D1");
        System.out.println("SKU = " + clonedDVD.getSKU());
        System.out.println("SKU = " + clonedDVD.getDescription());
        System.out.println("SKU = " + clonedDVD.getDuration());
    }

    public Product getProduct(String productCode) {
        Product cachedProduct = (Product) productMap.get(productCode);
        return (Product) cachedProduct.clone();
    }

    public void loadCache() {
        // for each product run expensive query and instantiate
        // product productMap.put(productKey, product);
        // for exemplification, we add only two products

        Book b1 = new Book();
        b1.setDescription("Oliver Twist");
        b1.setSKU("B1");
        b1.setNumberOfPages(100);
        productMap.put(b1.getSKU(), b1);

        DVD d1 = new DVD();
        d1.setDescription("Superman");
        d1.setSKU("D1");
        d1.setDuration(180);
        productMap.put(d1.getSKU(), d1);
    }
}
