package org.chiu.micro.gateway.server;

import org.chiu.micro.gateway.lang.Result;
import org.chiu.micro.gateway.req.BlogEditPushAllReq;
import org.chiu.micro.gateway.vo.BlogEditVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

public interface WebSocketServer {

    @PostExchange("/edit/push/all/{userId}")
    Result<Void> pushAll(@RequestBody BlogEditPushAllReq blog, @PathVariable Long userId);

    @GetMapping("/edit/pull/echo/{userId}")
    Result<BlogEditVo> findEdit(@RequestParam(value = "blogId", required = false) Long id, @PathVariable Long userId);
  
}
