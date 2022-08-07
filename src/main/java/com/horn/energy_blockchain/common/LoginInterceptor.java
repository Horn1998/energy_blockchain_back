package com.horn.energy_blockchain.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.horn.energy_blockchain.utils.HttpContextUtil;
import org.apache.commons.lang3.StringUtils; //導入方法依賴的package包/類
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
        //从header中获取token
        String token = request.getHeader("token");
        //如果token为空
        if(StringUtils.isBlank(token)){
            setReturn(response, 401, "用户未登录，请先登录");
            return false;
        }
        //在实际使用中还会
        //1.检验token是否能够解密出用户信息来获取访者
        //2.token是否已经过期
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    //返回json格式错误信息
    private static void setReturn(HttpServletResponse response, Integer code, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        //UTF-8编码
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        Result result = new Result(code,msg,"");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        httpResponse.getWriter().print(json);
    }
}
