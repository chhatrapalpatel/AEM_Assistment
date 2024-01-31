package com.assistment.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class, 
            property = {"sling.servlet.methods =" + HttpConstants.METHOD_GET,
        "sling.servlet.paths =" + "/bin/demo"})
public class NewPageCreationServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(NewPageCreationServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse res)
            throws ServletException, IOException {

        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            
            String path = "/content/aem_assistment/language-masters/en";
            String template_path = "/conf/aem_assistment/settings/wcm/templates/cp-page-template";

            for (int i = 1; i <= 6; i++) {
                String pageName = "Page" + i;
                String title = "Page" + i;
                
                Page createdPage = pageManager.create(path, pageName, template_path, title, true);
                resourceResolver.commit();
                res.setContentType("text/plain");
                res.getWriter().write(" " + createdPage);
            }
        } catch (Exception e) {
            res.getWriter().println("Error: "+e.getMessage());
        }
    }
}

