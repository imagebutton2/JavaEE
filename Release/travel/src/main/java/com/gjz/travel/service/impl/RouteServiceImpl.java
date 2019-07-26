package com.gjz.travel.service.impl;

import com.gjz.travel.dao.RouteDao;
import com.gjz.travel.dao.impl.RouteDaoImpl;
import com.gjz.travel.domain.PageBean;
import com.gjz.travel.domain.Route;
import com.gjz.travel.service.RouteService;

import java.util.List;

/**
 * 旅游线路商品的业务实现层
 */
public class RouteServiceImpl implements RouteService {
    //声明旅游线路的dao层对象
    private RouteDao routeDao = new RouteDaoImpl() ;
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<Route>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        int totalCount = routeDao.findTotalPage(cid, rname);
        pageBean.setTotalCount(totalCount);
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pageBean.setList(list);
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
