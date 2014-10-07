package com.nelson.junit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestLargest extends TestCase {

    public TestLargest(String method) {
        super(method);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        // Only include short tests
        suite.addTest(new TestLargest("testOrder"));
        suite.addTest(new TestLargest("testEmpty"));
        suite.addTest(new TestLargest("testDuplicates"));
        return suite;
    }

    public void testOrder() {
        assertEquals(9, Largest.largest(new int[]{8, 9, 7}));
        assertEquals(9, Largest.largest(new int[]{9, 8, 7}));
        assertEquals(9, Largest.largest(new int[]{7, 8, 9}));
    }

    public void testDuplicates() {
        assertEquals(9, Largest.largest(new int[]{8, 9, 7, 9}));
    }

    public void testNegNum() {
        assertEquals(-7, Largest.largest(new int[]{-8, -9, -7}));
    }

    public void testEmpty() {
        try {
            Largest.largest(new int[]{});
            fail("Should have thrown an exception");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

}
