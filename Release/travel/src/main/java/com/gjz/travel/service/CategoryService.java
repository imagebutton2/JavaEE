package com.gjz.travel.service;


import com.gjz.travel.domain.Category;

import java.util.List;

/**
 * 旅游分类的业务接口层
 */
public interface CategoryService {
    List<Category> findAll();
}
