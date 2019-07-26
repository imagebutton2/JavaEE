package com.gjz.travel.web.servlet;

import com.gjz.travel.domain.PageBean;
import com.gjz.travel.domain.Route;
import com.gjz.travel.service.RouteService;
import com.gjz.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 旅游线路的后台业务
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    //service层业务对象
    private RouteService routeService = new RouteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接收rname线路名称
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //3.调用Service完成后台封装-PageBean
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize, rname);
        //需要传递rname
        //将PageBean对象的总记录数/总记录数/当前页码封装完成

        //4.将pageBean对象直接返回给前台页面,发送json对象

        writeValue(pb, response);


    }


    //根据旅游编号查询旅游线路信息  ----->Route---->发送Route 到前台rote_detial.html
//    public void findByRid()


}
