/*
 * myTasks
 * July 7 2012
 */
package model;

import java.util.ArrayList;

/**
 * @author dimitri.tiago
 */
public class TaskComposite extends TaskComponent
{
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
}
