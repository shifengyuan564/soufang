package com.imooc.soufang.service.search;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 瓦力.
 */
@Setter
@Getter
public class HouseBucketDTO {

    private String key; // 聚合bucket的key
    private long count; // 聚合结果值

    public HouseBucketDTO(String key, long count) {
        this.key = key;
        this.count = count;
    }

}
