package com.example.tdpreview.dao;

import com.example.tdpreview.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByNameAndPwd(String name, String pwd);

    Optional<User> findByNameAndNo(String name, String no);

    Optional<User> findByNameAndPwdOrNoAndPwd(String name, String pwd, String name1, String pwd1);

}
