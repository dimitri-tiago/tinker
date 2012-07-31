/*
* myTasks
* July 7 2012
*/
package model;

import java.util.Iterator;

/**
 * @author dimitri.tiago
 */
public abstract class TaskComponent 
{
    private String name;
    private String description;
    
    public TaskComponent()
    {
        name        = "";
        description = "";
    }
    
    public void add(TaskComponent c)
    {
        throw new UnsupportedOperationException();
    }
    
    public void remove(TaskComponent c)
    {
        throw new UnsupportedOperationException();
    }
            
    public TaskComponent getChild(int index)
    {
        throw new UnsupportedOperationException();
    }    
    
    public Iterator getChildren()
    {
        throw new UnsupportedOperationException();
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
            
    public String getName()
    {
        return name;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void print()
    {
        throw new UnsupportedOperationException();
    }
    
    public abstract Iterator createIterator();
}
