package com.assistment.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.wcm.core.components.models.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.List;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { PageModel.class, ComponentExporter.class, ContainerExporter.class },
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PageModel implements Page, ComponentExporter, ContainerExporter {

    @Inject
    private String title;

    @Inject
    private String catagory;

    @Inject
    private String img;

    @Inject
    private String onTime;

    public String getCatagory() {
        return catagory;
    }

    public String getImg() {
        return img;
    }

    public String getOnTime() {
        return onTime;
    }


    @Override
    public String getTitle() {
        return title;
    }

    // Implement other methods from the Page interface if needed

    // Implement methods from ComponentExporter and ContainerExporter interfaces


    // Add getters for other properties

}