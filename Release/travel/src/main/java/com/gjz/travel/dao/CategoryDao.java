package com.gjz.travel.dao;


import com.gjz.travel.domain.Category;

import java.util.List;

/**
 * 分类的dao 接口层
 */
public interface CategoryDao {
    List<Category> findAll();
}
