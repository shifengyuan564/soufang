package com.imooc.soufang.repository;

import com.imooc.soufang.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: yuan
 * Date: 2018/12/20
 * Time: 16:39
 */
public interface UserRepository extends CrudRepository<User, Long> {    // 第二个是主键类型

}
