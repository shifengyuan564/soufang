package com.imooc.soufang.service.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 百度位置信息
 * Created by 瓦力.
 */
@Setter
@Getter
public class BaiduMapLocation {
    // 经度
    @JsonProperty("lon")
    private double longitude;

    // 纬度
    @JsonProperty("lat")
    private double latitude;

}
