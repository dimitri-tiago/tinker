/*
 * myTasks
 * July 7 2012
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dimitri.tiago
 */
public class TaskComposite extends TaskComponent
{
  private Iterator iterator;
  private ArrayList<TaskComponent> taskComponents;
  
    public TaskComposite()
    {
        super();
        taskComponents = new ArrayList<TaskComponent>();
    }
  
    @Override
    public void add(TaskComponent c)
    {
        taskComponents.add(c);
    }

    @Override
    public void remove(TaskComponent c)
    {
        taskComponents.remove(c);
    }

    @Override
    public TaskComponent getChild(int index)
    {   
        return taskComponents.get(index);
    }
    
    @Override
    public void print()
    {
        System.out.printf("%s: %s\n", getName(), getDescription());
        
        for (TaskComponent tc : taskComponents)
        {
            tc.print();
        }
    }

    @Override
    public Iterator createIterator() 
    {
       if (iterator == null)
       {
           iterator = new TaskCompositeIterator(taskComponents.iterator());
       }
       
       return iterator;
    }
}
