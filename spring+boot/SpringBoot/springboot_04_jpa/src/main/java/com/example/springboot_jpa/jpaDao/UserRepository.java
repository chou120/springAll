package com.example.springboot_jpa.jpaDao;

import com.example.springboot_jpa.pojo.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

}
