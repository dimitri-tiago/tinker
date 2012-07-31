/*
 * myTasks
 * July 24 2012
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskManager;

//TODO: remove model from controller. add java bean to request message in 
//      controller.

//TODO: implement bread-crumb pattren for task navigation.

/**
 *
 * @author dimitri.tiago
 */
public class TaskController extends HttpServlet 
{
    @Override
    public void init()
    {
       TaskManager taskManager = new TaskManager();
       getServletContext().setAttribute("taskManager", taskManager);
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        TaskManager taskManager = (TaskManager) getServletContext().getAttribute("taskManager");
        String operation = (String) request.getParameter("submit");

        if (operation.equals("Add List"))
        {
            // add task list to master list
            String listName         = (String) request.getParameter("listName");
            String listDescription  = (String) request.getParameter("listDescription");
            String parentList       = (String) request.getParameter("parentList");
            
            request.setAttribute("taskList", parentList);
            
            taskManager.addList(listName, listDescription, parentList);
        }
        else if (operation.equals("Add Task"))
        {
            // add task to list
            String taskName         = (String) request.getParameter("taskName");
            String taskDescription  = (String) request.getParameter("taskDescription");
            String taskList         = (String) request.getParameter("taskList");
            
            request.setAttribute("taskList", taskList);
            
            taskManager.addTask(taskName, taskDescription, taskList);
        }
        else if (operation.equals("Get Tasks"))
        {
            String taskList         = (String) request.getParameter("taskList");
            
            request.setAttribute("taskList", taskList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
