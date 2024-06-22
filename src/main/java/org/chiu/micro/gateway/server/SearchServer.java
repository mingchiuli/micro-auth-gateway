package org.chiu.micro.gateway.server;

import java.util.List;

import org.chiu.micro.gateway.lang.Result;
import org.chiu.micro.gateway.page.PageAdapter;
import org.chiu.micro.gateway.vo.BlogDocumentVo;
import org.chiu.micro.gateway.vo.BlogEntityVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface SearchServer {

  @GetExchange("/public/blog")
  Result<PageAdapter<BlogDocumentVo>> selectBlogsByES(@RequestParam(value = "currentPage") Integer currentPage, @RequestParam(value = "allInfo") Boolean allInfo, @RequestParam(value = "year") String year, @RequestParam(value = "keywords") String keywords);

  @GetExchange("/sys/blogs")
  Result<PageAdapter<BlogEntityVo>> searchAllBlogs(@RequestParam Integer currentPage, @RequestParam Integer size, @RequestParam(value = "keywords") String keywords, @RequestParam Long userId, @RequestBody List<String> roles);


  
}
