package com.imooc.soufang.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by 瓦力.
 */
@Getter
@Setter
@Entity
@Table(name = "subway_station")
public class SubwayStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subway_id")
    private Long subwayId;

    private String name;

}
