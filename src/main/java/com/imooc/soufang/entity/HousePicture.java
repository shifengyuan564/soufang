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
@Table(name = "house_picture")
public class HousePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    private String path;

    @Column(name = "cdn_prefix")
    private String cdnPrefix;

    private int width;

    private int height;

    private String location;

}
