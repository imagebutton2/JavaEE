package com.gjz.travel.domain;

import lombok.*;

import java.util.List;

/**
 * 分页实体类
 */

//mybatis--->分页插件
    //前端:boostrap:分页组件
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private int totalCount ; //总纪录数
    private int totalPage ;//总页数
    private int currentPage ;//当前页码
    private int pageSize ;//每页显示条数
    //当前页中的具体列表数据集合
    private List<T>  list ;
}
