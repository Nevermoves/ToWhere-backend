package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.PickEntity;

import java.util.List;

public interface PickDao {

    List<PickEntity> selectByUserid(int userid);
}
