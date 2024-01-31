// package com.assistment.core.Service.ServiceIMPL;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import javax.jcr.Session;
// import javax.jcr.query.Query;

// import org.apache.sling.api.resource.Resource;
// import org.apache.sling.api.resource.ResourceResolver;
// import org.apache.sling.api.resource.ResourceResolverFactory;
// import org.osgi.service.component.annotations.Component;
// import org.osgi.service.component.annotations.Reference;

// import com.assistment.core.Service.Article;
// import com.assistment.core.Service.ArticleOverviewService;
// import com.day.cq.search.PredicateGroup;
// import com.day.cq.search.result.SearchResult;


// @Component(service = ArticleOverviewService.class, immediate = true)
// public class ArticleOverviewServiceImpl implements ArticleOverviewService {

//     @Reference
//     private ResourceResolverFactory resolverFactory;

//     @Override
//     public List<Article> getArticles(String rootPagePath, int resultsPerPage) {
//         List<Article> articles = new ArrayList<>();

//         try (ResourceResolver resolver = resolverFactory.getServiceResourceResolver(null)) {

//             Map map = new HashMap();
//             map.put("path", "/content/aem_assistment/");
//             map.put("type", "cq:PageContent");

//             // Query query = builder.createQuery(PredicateGroup.create(map), session);

//             // query.setHitsPerPage(resultsPerPage);

//             // SearchResult result = query.getResult();

//             // for (Hit hit : result.getHits()) {
//                 // Resource pageResource = hit.getResource();
//                 Article article = new Article();


//         //         article.setImagePath(pageResource.getValueMap().get("img", String.class));
//         //         article.setCategory(pageResource.getValueMap().get("category", String.class));
//         //         article.setTitle(pageResource.getValueMap().get("jcr:title", String.class));
//         //         article.setDate(pageResource.getValueMap().get("date", Date.class));

//         //         articles.add(article);
//         //     }
//         // } catch (Exception e) {
//         //     e.printStackTrace();
//         // }

//     //     return articles;
//     // }
// }