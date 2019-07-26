package com.gjz.travel.dao.impl;

import com.gjz.travel.dao.CategoryDao;
import com.gjz.travel.domain.Category;
import com.gjz.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 旅游分类dao的实现层
 */
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";

        return template.query(sql,
                new BeanPropertyRowMapper<Category>(Category.class));
    }
}
