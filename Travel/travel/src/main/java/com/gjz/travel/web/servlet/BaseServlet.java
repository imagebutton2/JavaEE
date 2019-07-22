package com.gjz.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 抽查的基类
 */

//RegistUserServlet
    ///registUserServlet
public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // /   travle/user/add  :获取访问子类Servlet的uri的路径
        String uri = request.getRequestURI();
        System.out.println(uri);
        // 获取uri中的方法名add   travel/user/add
        String methodName = uri.substring(uri.lastIndexOf("/")+1)  ;//start end
        System.out.println(methodName);

        //1 .获取子类对象
        Class clazz = this.getClass();
        System.out.println(clazz);
        //2.调用子类中的方法
        //暴力反射(获取子类私有的/受保护的方法)
        try {
//            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            /**
             * 为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查
             */
            //(调用子类的方法,proptected修饰)
//            method.setAccessible(true);
            method.invoke(this,request,response) ;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
