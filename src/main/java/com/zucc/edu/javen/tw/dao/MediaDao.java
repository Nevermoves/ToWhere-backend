package com.zucc.edu.javen.tw.dao;

import com.zucc.edu.javen.tw.entity.MediaEntity;

import java.util.List;

public interface MediaDao {

    List<MediaEntity> getMedia(String medianame);
}
