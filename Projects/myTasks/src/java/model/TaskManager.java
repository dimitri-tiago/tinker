/*
 * myTasks
 * July 9 2012
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

//TODO: need to consider duplicate child list names policy (or use ids?)
//TODO: need to consider duplicate task item names policy (or use ids?)
//TODO: handle case when list added does not exist

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
    }
        
    /**
     * This method adds a child task list to a parent task list, if the 
     * parent task list is not defined the new list is added to the master 
     * task list.
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
        
        addTaskComponent(taskItem, (list.equals("")) ? "master" : list);
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
    
    /**
     * This method returns tasks for a patent list. If no list is specified, it
     * returns the tasks at the highest level (i.e. master tasks). If a list is 
     * specified but not found in the composite tree structure, it returns null.
     * @param parent parent list name.
     * @return <code>Iterator</code> for child tasks.
     */
    public Iterator getTasks(String parent)
    {
        // child tasks iterator
        ArrayList<String> childTasks = new ArrayList<String>();
        
        if ( (parent == null) || (parent.equals("")) )
        {
            // no parent specified.. return parents at highest level
            Iterator taskIterator = tasks.getChildren();
            while (taskIterator.hasNext())
            {
                TaskComponent tc = (TaskComponent) taskIterator.next();
                childTasks.add(tc.getName());
            }
            
            return childTasks.iterator();
        }
        else
        {
            TaskComposite parentComposite = getList(parent);
            if (parentComposite != null)
            {
                // parent list found, return its children
                Iterator taskIterator = parentComposite.getChildren();
                while (taskIterator.hasNext())
                {
                    TaskComponent tc = (TaskComponent) taskIterator.next();
                    childTasks.add(tc.getName());
                }
                
                return childTasks.iterator();
            }
            else
            {
                // parent list not found, return null.
                return null;
            }
        }
    }
    
    /**
     * This method returns tasks lists for a patent list. If no list is specified, it
     * returns the tasks lists at the highest level. If a list is 
     * specified but not found in the composite tree structure, it returns null.
     * @param parent parent list name.
     * @return <code>Iterator</code> for child task lists.
     */
    public Iterator getTaskLists(String parent)
    {
        // child tasks iterator
        ArrayList<String> taskLists = new ArrayList<String>();
        
        if ( (parent == null) || (parent.equals("")) )
        {
            // no parent specified.. return parents at highest level
            Iterator taskIterator = tasks.getChildren();
            while (taskIterator.hasNext())
            {
                TaskComponent tc = (TaskComponent) taskIterator.next();
                if (tc instanceof TaskComposite)
                {
                    taskLists.add(tc.getName());
                }
            }
            
            return taskLists.iterator();
        }
        else
        {
            TaskComposite parentComposite = getList(parent);
            if (parentComposite != null)
            {
                // parent list found, return its children
                Iterator taskIterator = parentComposite.getChildren();
                while (taskIterator.hasNext())
                {
                    TaskComponent tc = (TaskComponent) taskIterator.next();
                    if (tc instanceof TaskComposite)
                    {
                        taskLists.add(tc.getName());
                    }
                }
                
                return taskLists.iterator();
            }
            else
            {
                // parent list not found, return null.
                return null;
            }
        }
    }
    
    /**
     * This method returns tasks items for a patent list. If no list is specified, it
     * returns the tasks items at the highest level. If a list is 
     * specified but not found in the composite tree structure, it returns null.
     * @param parent parent list name.
     * @return <code>Iterator</code> for child task lists.
     */
    public Iterator getTasksItems(String parent)
    {
        // child tasks iterator
        ArrayList<String> taskItems = new ArrayList<String>();
        
        if ( (parent == null) || (parent.equals("")) )
        {
            // no parent specified.. return parents at highest level
            Iterator taskIterator = tasks.getChildren();
            while (taskIterator.hasNext())
            {
                TaskComponent tc = (TaskComponent) taskIterator.next();
                if (tc instanceof TaskItem)
                {
                    taskItems.add(tc.getName());
                }
            }
            
            return taskItems.iterator();
        }
        else
        {
            TaskComposite parentComposite = getList(parent);
            if (parentComposite != null)
            {
                // parent list found, return its children
                Iterator taskIterator = parentComposite.getChildren();
                while (taskIterator.hasNext())
                {
                    TaskComponent tc = (TaskComponent) taskIterator.next();
                    if (tc instanceof TaskItem)
                    {
                        taskItems.add(tc.getName());
                    }
                }
                
                return taskItems.iterator();
            }
            else
            {
                // parent list not found, return null.
                return null;
            }
        }
    }
}
