/*
 * myTasks
 * July 20 2012
 */
package model;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author dimitri.tiago
 */
public class TaskCompositeIterator implements Iterator
{
    private Stack stack = new Stack();
    
    public TaskCompositeIterator(Iterator iterator)
    {
        stack.push(iterator);
    }
    
    @Override
    public boolean hasNext() 
    {
        if (stack.isEmpty())
        {
            return false;
        }
        else
        {
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext())
            {
                stack.pop();
                return hasNext();
            }
            else
            {
                return true;
            }
        }
    }

    @Override
    public Object next() 
    {
        if (hasNext())
        {
            Iterator iterator = (Iterator) stack.peek();
            TaskComponent component = (TaskComponent) iterator.next();
            if (component instanceof TaskComposite && !(iterator instanceof TaskCompositeIterator))
            {
                stack.push(component.createIterator());
            }
            
            return component;
        }
        else
        {
            return null;
        }   
    }

    @Override
    public void remove() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
