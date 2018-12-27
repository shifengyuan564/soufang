package com.imooc.soufang.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 瓦力.
 */
@Setter
@Getter
public class HouseDTO implements Serializable {

    private static final long serialVersionUID = 8918735582286008182L;
    private Long id;
    private String title;
    private int price;
    private int area;
    private int direction;
    private int room;
    private int parlour;
    private int bathroom;
    private int floor;
    private Long adminId;
    private String district;
    private int totalFloor;
    private int watchTimes;
    private int buildYear;
    private int status;
    private Date createTime;
    private Date lastUpdateTime;
    private String cityEnName;
    private String regionEnName;
    private String street;
    private String cover;
    private int distanceToSubway;
    private HouseDetailDTO houseDetail;
    private List<String> tags;
    private List<HousePictureDTO> pictures;
    private int subscribeStatus;

    // 覆盖lombok
    public List<String> getTags() {
        return tags == null ? new ArrayList<>() : tags;
    }

    @Override
    public String toString() {
        return "HouseDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", floor=" + floor +
                ", totalFloor=" + totalFloor +
                ", watchTimes=" + watchTimes +
                ", buildYear=" + buildYear +
                ", status=" + status +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", cityEnName='" + cityEnName + '\'' +
                ", cover='" + cover + '\'' +
                ", houseDetail=" + houseDetail +
                ", pictures=" + pictures +
                '}';
    }
}
