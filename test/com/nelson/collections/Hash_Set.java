package com.nelson.collections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author trnelson
 */
public class Hash_Set {

    /**
     * In Java, hash tables are implemented as arrays of linked lists. Each list
     * is called a bucket. You would only use a HashSet if you don't care about
     * the ordering of the elements in the collection. Best load factor is 0.75
     * The HashSet implements a set based on a hash table.
     *
     * @param args Command Line entries.
     */

    public static void main(String[] args) {

        Set<String> words = new HashSet<>();
        long totalTime = 0;

        Scanner in;
        try {
            in = new Scanner(new FileReader("count.txt"));
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }

//			Iterator<String> iter = words.iterator();
//			for (int i = 1; i <= 20; i++) {
//				System.out.println(iter.next());
//			}
            System.out.println(". . .");
            System.out.println(words.size() + " distinct words " + totalTime + " milliseconds.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
