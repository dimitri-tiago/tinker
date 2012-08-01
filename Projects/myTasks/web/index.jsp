<%-- 
    Document   : index
    Created on : Jul 7, 2012, 8:27:52 AM
    Author     : dimitri.tiago
--%>

<%@page import="model.TaskManager"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dimitri Tiago : {myTasks}</title>
    </head>
    <body>
        <a href="TaskController?submit=Get%20Tasks&amp;task-list=">
            <h1>Dimitri Tiago : {myTasks}</h1>
        </a>
        
        <form id = "addTask" method = "GET" action = "TaskController">
            <p>
                <input type = "text" name = "task"  value = "" />
                <input type = "submit" name = "submit"  value = "Add Task" />
                <input type = "submit" name = "submit"  value = "Add List" />
                <input type = "hidden" name = "task-list" value = "${param['task-list']}" />
            </p>
        </form> 
        
        <%  
            TaskManager taskManager = (TaskManager) getServletContext().getAttribute("taskManager");
            if (taskManager != null)
            {
                String taskList = (String) request.getAttribute("task-list");

                out.println("<h1>" + taskList + "</h1>");
                
                Iterator taskListIterator = taskManager.getTaskLists(taskList);
                while (taskListIterator.hasNext())
                {
                   String taskListIteratorItem = (String) taskListIterator.next(); 
                   out.println("<p>" 
                           + "<a href=\"TaskController?submit=Get%20Tasks&amp;task-list=" + taskListIteratorItem + "\">"
                           + taskListIteratorItem
                           + "</a>"
                           + "</p>");
                }  

                Iterator taskItemsIterator = taskManager.getTasksItems(taskList);
                while (taskItemsIterator.hasNext())
                {
                   out.println("<p>" + taskItemsIterator.next() + "</p>");
                }
            }
        %>      
    </body>
</html>