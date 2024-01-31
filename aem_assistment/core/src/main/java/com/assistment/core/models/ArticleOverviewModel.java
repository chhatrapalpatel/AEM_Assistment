package com.assistment.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;

import com.assistment.core.Service.Article;
import com.assistment.core.Service.ArticleOverviewService;



@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ArticleOverviewModel {

    @ValueMapValue
    private String rootPagePath;

    @ValueMapValue
    private int resultsPerPage;

    private List<Article> articles;

    @Reference
    private ArticleOverviewService articleOverviewService;

    @PostConstruct
    protected void init() {
        articles = articleOverviewService.getArticles(rootPagePath, resultsPerPage);
    }

    public List<Article> getArticles() {
        return articles;
    }
}
