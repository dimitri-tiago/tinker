/*
 * myTasks
 * July 9 2012
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

//TODO: need to consider duplicate child list names policy (or use ids?)
//TODO: need to consider duplicate task item names policy (or use ids?)

/**
 * @author dimitri.tiago
 */
public class TaskManager 
{
    private TaskComposite tasks;    // tasks to manage
    
    public TaskManager()
    {
        // instantiate master list to hold all tasks and lists.
        tasks = new TaskComposite();
        tasks.setName("master");
        tasks.setDescription("master task list.");
        
        // add default list to master task list
        TaskComposite generalTasks = new TaskComposite();
        generalTasks.setName("general");
        generalTasks.setDescription("General tasks.");
        tasks.add(generalTasks);
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
    public void addList(String name, String description, String parentList)
    {
        TaskComposite taskList = new TaskComposite();
        taskList.setName(name);
        taskList.setDescription(description);
 
        addTaskComponent(taskList, (parentList.equals("")) ? "master" : parentList);
    }
    
    /**
     * This method adds a task to a list. If the list name is not passed the 
     * task is added to the general list.
     * @param name new task name
     * @param description new task description
     * @param list task list name
     */
    public void addTask(String name, String description, String list)
    {
        TaskItem taskItem = new TaskItem();
        taskItem.setName(name);
        taskItem.setDescription(description);
        
        addTaskComponent(taskItem, (list.equals("")) ? "general" : list);
    }
    
    private void addTaskComponent(TaskComponent taskComponent, String list)
    {
        if (list.equals("master"))
        {
            // if list is "master" ... add component to master list
            // TODO: handle case when task component has duplicate name
            tasks.add(taskComponent);
        }
        else
        {
            // attempt to retrieve parent task list ...
            TaskComposite parentList = getList(list);
            if ( (parentList != null) && (!parentList.getName().equals(taskComponent.getName())) )
            {
                // ... desired parent list found, 
                // and new list name != parent list name,
                // add child task component (i.e. task list or item) to parent list
                parentList.add(taskComponent);
            }
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
    
    public Iterator getTasks()
    {
        ArrayList<String> allTasks = new ArrayList<String>();
    
        Iterator taskIterator = tasks.createIterator();
        while (taskIterator.hasNext())
        {
            TaskComponent taskComponent = (TaskComponent) taskIterator.next();
            allTasks.add(taskComponent.getName());
        }
        
        return allTasks.iterator();
    }
}
