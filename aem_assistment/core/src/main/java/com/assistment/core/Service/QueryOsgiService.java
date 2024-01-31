package com.assistment.core.Service;

import java.util.List;
import com.assistment.core.models.PageInfo;


public interface QueryOsgiService {
    List<PageInfo> getPagesWithTemplate(String templatePath, String basePath);
    
}
