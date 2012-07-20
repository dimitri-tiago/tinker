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
 
        // attempt to retrieve parent task list ...
        TaskComposite parentList = getList(list);
        if ( (parentList != null) && (!parentList.getName().equals(newList.getName())) )
        {
            // ... desired parent list found, 
            // and new list name != parent list name,
            // add child list to parent list
            parentList.add(newList);
        }
    }
    
    /**
     * This method adds a task to a list. If the list name is not passed the 
     * task is added to the master list.
     * @param name new task name
     * @param description new task description
     * @param list task list name
     */
    public void addTask(String name, String description, String list)
    {
        TaskItem taskItem = new TaskItem();
        taskItem.setName(name);
        taskItem.setDescription(description);
        
        // attempt to retrieve task list
        TaskComposite taskList = getList(list);
        if (taskList != null)
        {
            // ... list found, add task to list.
            taskList.add(taskItem);
        }
    }
    
    /**
     * This method returns a task list that matches the list name we are 
     * interested in.
     * @param list task list name
     * @return task list
     */
    public TaskComposite getList(String list)
    {
        // retrieve task list
        Iterator taskIterator = tasks.createIterator();
        while (taskIterator.hasNext())
        {
            TaskComponent taskComponent = (TaskComponent) taskIterator.next();
            if (taskComponent instanceof TaskComposite)
            {
                // if a task list has been found...
                if (taskComponent.getName().equals(list))
                {
                    // ... and it is the one we want,
                    // return it 
                    return (TaskComposite) taskComponent;
                }
            }
        }
        
        // task list not found
        return null;
    }
}
