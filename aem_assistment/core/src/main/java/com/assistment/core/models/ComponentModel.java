package com.assistment.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import com.assistment.core.Service.QueryOsgiService;


 @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ComponentModel {
  
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    private String message;

    @Inject
    private String templatePath;
    
    @Inject
    private String basePath;

    @OSGiService
    QueryOsgiService QueryOsgiService;

    private List<PageInfo> pageInfoList=new ArrayList<PageInfo>();

    @PostConstruct
    protected void init() {
        pageInfoList=QueryOsgiService.getPagesWithTemplate(templatePath, basePath);
    }

    public List<PageInfo> getPageInfoList() {
        return pageInfoList;
    }

    public String getMessage() {
        return message;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public String getBasePath() {
        return basePath;
    }
    
}
