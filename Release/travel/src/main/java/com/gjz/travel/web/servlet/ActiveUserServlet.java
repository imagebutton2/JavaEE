package com.gjz.travel.web.servlet;

import com.gjz.travel.service.UserService;
import com.gjz.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.接收激活码
        String code = request.getParameter("code");
        //2.判断激活码是否为空
        if (code != null) {
            //存在.调用service完成激活功能
            UserService userService = new UserServiceImpl();
            boolean flag = userService.active(code);

            //3.提示信息 (直接向浏览器响应内容)
            String msg = "";
            if (flag) {
                //激活成功了
                msg = "您已经激活成功了,请<a href='http://101.132.101.227:8080/travel/login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败,请联系管理人员";
            }
            //设置中文乱码
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);

        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
