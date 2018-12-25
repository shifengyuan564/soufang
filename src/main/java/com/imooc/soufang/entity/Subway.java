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
@Table(name = "subway")
public class Subway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "city_en_name")
    private String cityEnName;

}
