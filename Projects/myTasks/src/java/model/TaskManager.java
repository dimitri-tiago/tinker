/*
 * myTasks
 * July 9 2012
 */
package model;

import java.util.Iterator;

/**
 * @author dimitri.tiago
 */
public class TaskManager 
{
    private TaskComposite tasks;    // tasks to manage
    
    public TaskManager()
    {
        tasks = new TaskComposite();
        tasks.setName("master");
        tasks.setDescription("master task list.");
    }
    
    /**
     * This method adds a new task composite (i.e. list of tasks) 
     * to the "master" task composite (i.e. top level of the composite tree).
     * @param name task list name
     * @param description task list description
     */
    public void addList(String name, String description)
    {
        addList(name, description, "master");
    }
    
    /**
     * This method adds a child task list to a parent task list
     * @param name new task list name
     * @param description new task list description
     * @param list parent task list name
     */
    public void addList(String name, String description, String list)
    {
        // create child task list
        TaskComposite newList = new TaskComposite();
        newList.setName(name);
        newList.setDescription(description);
        
        // retrieve parent task list
        Iterator taskIterator = tasks.createIterator();
        while (taskIterator.hasNext())
        {
            TaskComponent taskComponent = (TaskComponent) taskIterator.next();
            if (taskComponent instanceof TaskComposite)
            {
                // if task list has been found...
                if ( (taskComponent.getName().equals(list)) && (!newList.getName().equals(list)) )
                {
                    // ... and desired parent list found, 
                    // and new list name != parent list name,
                    // add child list to parent list
                    taskComponent.add(newList);
                }
            }
        }
    }
    
    public void addTask(String name, String description, String listName)
    {
        TaskItem taskItem = new TaskItem();
        taskItem.setName(name);
        taskItem.setDescription(description);
        
        //get list and add task to list
    }
}
