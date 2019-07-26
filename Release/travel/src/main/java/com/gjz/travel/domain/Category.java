package com.gjz.travel.domain;

import lombok.*;

import java.io.Serializable;

/**
 * 分类实体类
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private int cid;//分类id
    private String cname;//分类名称

}
