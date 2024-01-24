package com.assistment.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import com.day.cq.wcm.api.PageManager;

import javax.servlet.ServletException;
import java.io.IOException;

public class PageCreationServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            createPages(request);
            response.getWriter().write("Pages created successfully.");
        } catch (Exception e) {
            response.getWriter().write("Error creating pages: " + e.getMessage());
        }
    }

    private void createPages(SlingHttpServletRequest request) {
        try {
            ResourceResolver resolver = request.getResourceResolver();
            PageManager pageManager = resolver.adaptTo(PageManager.class);

            String parentPagePath = "/content/aem_assistment/language-masters/en";
            String templatePath = "/conf/aem_assistment/settings/wcm/templates/cp-page-template";


            for (int i = 1; i <= 6; i++) {
                String pageName = "new-page-" + i;
                String pageTitle = "New Page " + i;
                String pagePath = parentPagePath + "/" + pageName;
               

                if (pageManager.getPage(pagePath) == null) {

                    pageManager.create(parentPagePath, pageName, templatePath, pageTitle);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
