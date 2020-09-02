package com.own.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 处理登录请求的Servlet
 Servlet是sun公司制定的标准，Tomcat（web应用服务器、Servlet容器）实现了这些标准
 遵循tomcat的标准，使用提供的HttpServlet
 */

public class LoginServlet extends HttpServlet {
    /**
     * doGet  处理客户端的get请求
     * doPost  处理客户端的post请求
     *
     * service    根据具体的请求方式调用对应的doGet和doPost方法
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet登录...");
        /**
         * HttpServletRequest：请求对象  Servlet容器会在请求达到后，创建一个request对象，将HTTP请求相关的信息全部封装到该对象中
         */
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+password);
        resp.setContentType("text/html;charset=UTF-8");//响应不乱码
        PrintWriter out=resp.getWriter();
        if("admin".equalsIgnoreCase(username)&&"admin".equalsIgnoreCase(password)){
            //通过响应对象  HttpServletResponse  给客户端响应数据

            out.println("<h1>success成功<h1/>");
        }else{
            out.println("failure失败");
            /**
             * 通过重定向的方式去往登录页面
             * 服务器会给浏览器发送一个302状态码以及一个新的地址
             */
            resp.sendRedirect("login.html");
        }
    }
}
