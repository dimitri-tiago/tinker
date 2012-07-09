/*
 * myTasks
 * July 9 2012
 */
package model;

/**
 *
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
    
    public void addList(String name, String description)
    {
        TaskComposite newList = new TaskComposite();
        newList.setName(name);
        newList.setDescription(description);
    }
    
    public TaskComposite getList(String name)
    {
        // todo
        return null;
    }
    
    public void addTask(String name, String description, String listName)
    {
        TaskItem taskItem = new TaskItem();
        taskItem.setName(name);
        taskItem.setDescription(description);
        
        //get list and add task to list
    }
}
