package com.nelson.dpatterns.creational.builder;

/**
 * Definition:
 * <p/>
 * The Builder pattern can be used to ease the construction of a complex object
 * from simple objects. The Builder pattern also separates the construction of a
 * complex object from its representation so that the same construction process
 * can be used to create another composition of objects. Related patterns
 * include Abstract Factory and Composite.
 * <p/>
 * Where to use:
 * <p/>
 * When the algorithm for creating a complex object should be independent of the
 * parts that make up the object and how they are assembled.
 * <p/>
 * When the construction process must allow different representations for the
 * object that is constructed.
 * <p/>
 * When you want to insulate clients from the knowledge of the actual creation
 * process and/or resulting product.
 * <p/>
 * Benefits:
 * <p/>
 * The built object is shielded from the details of its construction.
 * <p/>
 * Code for construction is isolated from code for representation and both are
 * easy to replace without affecting the other.
 * <p/>
 * Gives you control over the construction process.
 * <p/>
 * Gives you the possibility to reuse and/or change the process and/or product
 * independently.
 * <p/>
 * Drawbacks/consequences:
 * <p/>
 * Need flexibility in creating various complex objects. Need to create complex,
 * aggregate objects.
 */

public class HouseClientTest {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector();
        HouseBuilder woodBuilder = new WoodBuilder();
        BrickBuilder brickBuilder = new BrickBuilder();

        // Build a wooden house
        House woodHouse = houseDirector.construcHouse(woodBuilder);
        System.out.println("Finished " + woodHouse.getRepresentation());
        System.out.println();

        // Build a brick house
        House brickHouse = houseDirector.construcHouse(brickBuilder);
        System.out.println("Finished " + brickHouse.getRepresentation());
    }
}
