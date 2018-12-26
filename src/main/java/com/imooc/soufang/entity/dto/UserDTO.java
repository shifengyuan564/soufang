package com.imooc.soufang.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 瓦力.
 */
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String avatar;
    private String phoneNumber;
    private String lastLoginTime;

}
