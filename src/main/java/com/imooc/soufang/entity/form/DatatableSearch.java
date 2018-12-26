package com.imooc.soufang.entity.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 瓦力.
 */

@Setter
@Getter
public class DatatableSearch {
    /**
     * Datatables 要求回显字段
     */
    private int draw;

    /**
     * Datatables 规定的分页字段
     */
    private int start;
    private int length;
    private Integer status; // int类型表示一定会传的，Integer可能不传，null代表所有的状态

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMax;

    private String city;
    private String title;
    private String direction;
    private String orderBy;

}
