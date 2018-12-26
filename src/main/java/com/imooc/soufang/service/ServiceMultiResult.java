package com.imooc.soufang.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通用 多结果Service返回结构
 * Created by 瓦力.
 */


@Setter
@Getter
public class ServiceMultiResult<T> {

    private long total;
    private List<T> result;

    public ServiceMultiResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public int getResultSize() {
        if (this.result == null) {
            return 0;
        }
        return this.result.size();
    }
}
