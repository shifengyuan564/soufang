package com.imooc.soufang.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by 瓦力.
 */
@Setter
@Getter
@Entity
@Table(name = "house_tag")
public class HouseTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    private String name;

    public HouseTag() {
    }

    public HouseTag(Long houseId, String name) {
        this.houseId = houseId;
        this.name = name;
    }
}
