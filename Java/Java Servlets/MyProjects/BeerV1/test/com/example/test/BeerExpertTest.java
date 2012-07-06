package com.example.test;

import junit.framework.TestCase;
import java.util.ArrayList;

import com.example.model.BeerExpert;

/**
 * @author dimitri.tiago
 */
public class BeerExpertTest extends TestCase
{
    BeerExpert beerExpert;  // class under test

    public BeerExpertTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        beerExpert = new BeerExpert();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    // test methods 
    public void testGetBrands()
    {
        ArrayList<String> beerAdvice = new ArrayList<String>();
        String beerTypes [] = {"Light","Amber","Brown","Dark"};

        // insect that every input returns a valid output
        for(String s: beerTypes)
        {
            beerAdvice = beerExpert.getBrands(s);
            assertNotNull(beerAdvice);
        }
    }
}