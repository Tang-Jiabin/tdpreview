package com.example.tdpreview.dao;

import com.example.tdpreview.pojo.Msg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgRepository extends JpaRepository<Msg,Integer> {
}
