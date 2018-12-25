package com.imooc.soufang.repository;

import com.imooc.soufang.entity.HousePicture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {

    List<HousePicture> findAllByHouseId(Long id);
}
