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
        <title>Dimitri Tiago {myTasks}</title>
    </head>
    <body>
        <h1>Dimitri Tiago {myTasks}</h1>
        
        <%  
            TaskManager taskManager = (TaskManager) getServletContext().getAttribute("taskManager");
            if (taskManager != null)
            {
                String taskList   = (String) request.getAttribute("taskList");
                Iterator allTasks = taskManager.getTasks(taskList);
                while (allTasks.hasNext())
                {
                    out.println("<p>" + allTasks.next() + "</p>");
                }
            }
        %>
        
        <form id = "addTaskList" method = "GET" action = "TaskController">
            <h3>Add list:</h3>
            
            <p>
                <label id = "listNameLabel" for="listName">List name: </label>
                <input type = "text" id = "listName" name = "listName"  value = "" />
            </p>
            <p>
                <label id = "listDescriptionLabel" for="listDescription">Description: </label>
                <textarea id="listDescription" name="listDescription" rows="3" cols="50" ></textarea>
            </p>
            <p>
                <label id = "parentListLabel" for="parentList">Parent list: </label>
                <input type = "text" id = "parentList" name = "parentList"  value = "" />
            </p>
            <p>
                <input type = "submit" id = "submit" name = "submit"  value = "Add List" />
            </p>
        </form>
        
        <form id = "addTask" method = "GET" action = "TaskController">
            <h3>Add task:</h3>
            
            <p>
                <label id = "taskNameLabel" for="taskName">Task name: </label>
                <input type = "text" id = "taskName" name = "taskName"  value = "" />
            </p>
            <p>
                <label id = "taskDescriptionLabel" for="taskDescription">Description: </label>
                <textarea id="taskDescription" name="taskDescription" rows="3" cols="50" ></textarea>
            </p>
            <p>
                <label id = "taskListLabel" for="taskList">Task list: </label>
                <input type = "text" id = "taskList" name = "taskList"  value = "" />
            </p>
            <p>
                <input type = "submit" id = "submit" name = "submit"  value = "Add Task" />
            </p>
        </form>
    </body>
</html>
