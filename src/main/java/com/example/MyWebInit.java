package com.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        var context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/application-context.xml");

        var distpacher = servletContext.addServlet("distpacher", new DispatcherServlet(context));
        distpacher.addMapping("/app/*");
    }
}
