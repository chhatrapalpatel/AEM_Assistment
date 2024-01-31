package com.assistment.core.Service;

import java.util.List;

public interface ArticleOverviewService {
    
    public List<Article> getArticles(String rootPagePath, int resultsPerPage);
    
} 