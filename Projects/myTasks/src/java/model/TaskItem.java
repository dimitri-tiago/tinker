/*
 * myTasks
 * July 7 2012
 */
package model;

/**
 * @author dimitri.tiago
 */
public class TaskItem extends TaskComponent
{
    public TaskItem()
    {
        super();
    }
    
    @Override
    public void print()
    {
        System.out.printf("%s\n", getName());
    }
}
