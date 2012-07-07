/*
* myTasks 
* July 7 2012
*/
package model.test;

import model.*;

/**
 * @author dimitri.tiago
 */
public class myTasksClient 
{
    public static void main(String args[])
    {
        TaskComposite taskList = new TaskComposite();
        taskList.setName("Daily Tasks");
        taskList.setDescription("Tasks assigned for today.");
        
        TaskComponent myTask1 = new TaskItem();
        myTask1.setName("US1: Create Task List.");
        
        TaskComponent myTask2 = new TaskItem();
        myTask2.setName("US2: Record Task in Task List.");
        
        taskList.add(myTask1);
        taskList.add(myTask2);
        
        taskList.print();
    }
}
