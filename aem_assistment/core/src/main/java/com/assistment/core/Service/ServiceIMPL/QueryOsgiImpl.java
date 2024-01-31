package com.assistment.core.Service.ServiceIMPL;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.factory.ModelFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.assistment.core.Service.QueryOsgiService;
import com.assistment.core.models.PageInfo;

@Component(service = QueryOsgiService.class)
public class QueryOsgiImpl implements QueryOsgiService {

    @Reference
    private ModelFactory modelFactory;

    @Reference
    ResourceResolverFactory resolverFactory;


    @Override
    public List<PageInfo> getPagesWithTemplate(String templatePath, String basePath) {
        List<PageInfo> pages = new ArrayList<>();

        try (ResourceResolver resolver = resolverFactory.getServiceResourceResolver(null)) {

            String query = "SELECT * FROM [cq:Page] AS page WHERE ISDESCENDANTNODE(page, '" + basePath + "') "
                    + "AND page.[jcr:content/cq:template] = '" + templatePath + "'";
            Iterator<Resource> result = resolver.findResources(query, "sql");

            while (result.hasNext()) {
                Resource pageResource = result.next();
                ValueMap valueMap = pageResource.adaptTo(ValueMap.class);

                String pagePath = pageResource.getPath();
                String pageTitle = valueMap.get("jcr:content/jcr:title", String.class);

                pages.add(new PageInfo(pagePath, pageTitle));
            }
        } catch (Exception e) {
            
        }

        return pages;
    }
}
