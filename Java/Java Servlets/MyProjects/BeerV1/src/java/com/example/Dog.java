package com.example;

/**
 * @author dimitri.tiago
 */
public class Dog
{
    private String breed;

    /**
     * One argument constructor creates a dog object of a specific breed.
     * @param breed <code>String</code> holding dog breed name.
     */
    public Dog(String breed)
    {
        this.breed = breed;
    }

    /**
     * Obtain dog breed.
     * @return <code>String</code> holding dog breed name.
     */
    public String getBreed()
    {
        return breed;
    }
}
