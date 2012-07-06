package com.example.model;

import java.util.ArrayList;

/**
 * @author dimitri.tiago
 */
public class BeerExpert
{
    public BeerExpert()
    {

    }

    /**
     * Get beer brands of a beer color.
     * @param color beer color
     * @return <code>ArrayList<String></code> holding beer brand names.
     */
    public ArrayList<String> getBrands(String color)
    {
        ArrayList<String> beerBrands = new ArrayList<String>();

        // determine beer color and provide brand advice
        if ( color.equalsIgnoreCase("Amber") )
        {
            beerBrands.add( "Jack Amber" );
            beerBrands.add( "Red Moose" );
        }
        else
        {
            beerBrands.add( "Jail Pale Ale" );
            beerBrands.add( "Gout Stout" );
        }

        return beerBrands;
    }
}
