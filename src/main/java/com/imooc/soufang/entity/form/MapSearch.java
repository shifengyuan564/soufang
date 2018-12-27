package com.imooc.soufang.entity.form;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 瓦力.
 */
@Setter
@Getter
public class MapSearch {

    private String cityEnName;

    /**
     * 地图缩放级别
     */
    private int level = 12;
    private String orderBy = "lastUpdateTime";
    private String orderDirection = "desc";
    /**
     * 左上角
     */
    private Double leftLongitude;
    private Double leftLatitude;

    /**
     * 右下角
     */
    private Double rightLongitude;
    private Double rightLatitude;

    private int start = 0;
    private int size = 5;


    public int getStart() {
        return start < 0 ? 0 : start;
    }
    public int getSize() {
        return size > 100 ? 100 : size;
    }

}
