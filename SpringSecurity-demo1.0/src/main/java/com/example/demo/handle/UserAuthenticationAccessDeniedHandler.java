package com.example.demo.handle;

import com.example.demo.common.JsonData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by linziyu on 2019/2/13.
 *
 * 无权限操作时的处理类
 */

@Component("UserAuthenticationAccessDeniedHandler")
@Slf4j
public class UserAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        log.info("{}","无权限处理");
        JsonData jsonData = new JsonData(500,"error");
        String json = new Gson().toJson(jsonData);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();

        out.write(json);
        out.flush();
        out.close();
    }
}
