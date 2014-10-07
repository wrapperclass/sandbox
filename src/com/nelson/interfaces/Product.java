/**
 *
 */
package com.nelson.interfaces;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author trnelson
 */
public class Product implements Printable {

    private String code;
    private String description;
    private String price;

    public Product(final String code, final String description, final String price) {

        this.code = code;
        this.description = description;
        this.price = price;
    }

    public static void main(String[] args) {

        Printable product = new Product("java", "Java 2", "49.50");
        product.print();
    }

    @Override
    public void print() {

        System.out.println("Code:\t\t\t" + code);
        System.out.println("Description:\t" + description);
        System.out.println("Price:\t\t\t" + this.getFormattedPrice());
    }

    private Number getFormattedPrice() {

        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        Number number = null;
        try {
            number = nf.parse(this.price);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number;
    }

}
