/*
 * myTasks
 * July 20 2012
 */
package model;

import java.util.Iterator;

/**
 * @author dimitri.tiago
 */
public class NullIterator implements Iterator
{
    @Override
    public boolean hasNext() 
    {
        return false;
    }

    @Override
    public Object next() 
    {
        return null;
    }

    @Override
    public void remove() 
    {
        throw new UnsupportedOperationException("Not supported.");
    }
    
}
