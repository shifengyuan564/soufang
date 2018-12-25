package com.imooc.soufang.service.search;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 瓦力.
 */


@Setter
@Getter
public class HouseSuggest {

    private String input;
    private int weight = 10; // 默认权重
}
