package org.chiu.micro.auth.server;

import java.util.List;

import org.chiu.micro.auth.lang.Result;
import org.chiu.micro.auth.page.PageAdapter;
import org.chiu.micro.auth.req.BlogEditPushAllReq;
import org.chiu.micro.auth.req.BlogEntityReq;
import org.chiu.micro.auth.req.DeleteBlogsReq;
import org.chiu.micro.auth.req.ImgUploadReq;
import org.chiu.micro.auth.vo.BlogDeleteVo;
import org.chiu.micro.auth.vo.BlogEditVo;
import org.chiu.micro.auth.vo.BlogEntityVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;


public interface BlogServer {

    @PostExchange("/save/{userId}")
    Result<Void> saveOrUpdate(@RequestBody BlogEntityReq blog, @PathVariable Long userId);

    @PostExchange("/delete")
    Result<Void> deleteBatch(@RequestBody DeleteBlogsReq req);

    @GetExchange("/lock/{blogId}/{userId}")
    Result<String> setBlogToken(@PathVariable(value = "blogId") Long blogId, @PathVariable(value = "userId") Long userId);

    @GetExchange("/blogs/{userId}")
    Result<PageAdapter<BlogEntityVo>> findAllABlogs(@RequestParam(value = "currentPage", required = false) Integer currentPage, @RequestParam(value = "size", required = false) Integer size, @PathVariable Long userId, @RequestBody List<String> roles);

    @GetExchange("/deleted/{userId}")
    Result<PageAdapter<BlogDeleteVo>> findDeletedBlogs(@RequestParam(value = "currentPage") Integer currentPage, @RequestParam(value = "size") Integer size, @PathVariable Long userId);

    @GetExchange("/recover/{idx}/{userId}")
    Result<Void> recoverDeletedBlog(@PathVariable(value = "idx") Integer idx, @PathVariable(value = "userId") Long userId);

    @PostExchange("/oss/upload/{userId}")
    Result<String> uploadOss(@RequestBody ImgUploadReq image, @PathVariable Long userId);

    @GetExchange("/oss/delete")
    Result<Void> deleteOss(@RequestParam String url);

    @GetExchange("/download")
    byte[] download();

    @PostExchange("/edit/push/all/{userId}")
    Result<Void> pushAll(@RequestBody BlogEditPushAllReq blog, @PathVariable Long userId);

    @GetExchange("/edit/pull/echo/{userId}")
    Result<BlogEditVo> findEdit(@RequestParam(value = "blogId", required = false) Long id, @PathVariable Long userId);
}
