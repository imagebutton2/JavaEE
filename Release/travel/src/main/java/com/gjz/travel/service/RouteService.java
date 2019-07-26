package com.gjz.travel.service;


import com.gjz.travel.domain.PageBean;
import com.gjz.travel.domain.Route;

/**
 * 旅游线路商品的业务接口层
 */
public interface RouteService {
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);
}
