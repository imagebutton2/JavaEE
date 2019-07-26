package com.gjz.travel.dao.impl;

import com.gjz.travel.dao.RouteDao;
import com.gjz.travel.domain.Route;
import com.gjz.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 旅游线路商品的dao的实现层
 */
public class RouteDaoImpl implements RouteDao {
    //声明查询模板对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()) ;
    @Override
    public int findTotalPage(int cid,String rname) {


        /**
         * 通过分类id查询总记录数
         * 或者是通过线路名称模糊查询
         * @param cid
         * @return
         */
        String sql = "select count(*) from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    /**
     * 查询当前页面数据集合,通过分页查询
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        String sql = "select * from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sb.append(" limit ?, ?");
        sql = sb.toString();
        params.add(start);
        params.add(pageSize);
        return template.query(sql,
                new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }
}
