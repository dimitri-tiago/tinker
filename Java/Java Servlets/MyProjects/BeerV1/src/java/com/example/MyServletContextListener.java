package com.example;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

/**
 * @author dimitri.tiago
 */
public class MyServletContextListener implements ServletContextListener
{
    /**
     * ServletContext initialized listener
     * @param event servlet context initialized <code>event</code> Object.
     */
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        // obtain servlet context
        ServletContext servletContext = event.getServletContext();

        // instantiate dog object and set servlet context attribute
        String dogBreed = (String) servletContext.getInitParameter("breed");
        Dog myDog = new Dog(dogBreed);

        servletContext.setAttribute("dog", myDog);
    }

    /**
     * ServletContext destroyed listener
     * @param event servlet context destroyed <code>event</code> Object.
     */
    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        // return resources(e.g. database connection object).
    }
}