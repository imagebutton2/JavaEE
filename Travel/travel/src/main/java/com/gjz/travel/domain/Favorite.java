package com.gjz.travel.domain;

import lombok.*;

import java.io.Serializable;

/**
 * 收藏实体类
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Favorite implements Serializable {
    private Route route;//旅游线路对象
    private String date;//收藏时间
    private User user;//所属用户


}
