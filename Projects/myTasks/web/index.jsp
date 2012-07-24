<%-- 
    Document   : index
    Created on : Jul 7, 2012, 8:27:52 AM
    Author     : dimitri.tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to myTasks!</title>
    </head>
    <body>
        <h1>myTasks</h1>
        
        <form id = "addTaskList" method = "GET" action = "TaskController">
            <h2>Add Task List:</h2>
            
            <p>
                <label id = "listNameLabel" for="listName">List name: </label>
                <input type = "text" id = "listName" name = "listName"  value = "" />
            </p>
            <p>
                <label id = "listDescriptionLabel" for="listDescription">Description: </label>
                <input type = "text" id = "listDescription" name = "listDescription"  value = "" />
            </p>
            <p>
                <input type = "submit" id = "submit" name = "submit"  value = "Add Task List" />
            </p>
        </form>
        
        <form id = "addTask" method = "GET" action = "TaskController">
            <h2>Add Task:</h2>
            
            <p>
                <label id = "taskNameLabel" for="taskName">Task name: </label>
                <input type = "text" id = "taskName" name = "taskName"  value = "" />
            </p>
            <p>
                <label id = "taskDescriptionLabel" for="taskDescription">Description: </label>
                <input type = "text" id = "taskDescription" name = "taskDescription"  value = "" />
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
