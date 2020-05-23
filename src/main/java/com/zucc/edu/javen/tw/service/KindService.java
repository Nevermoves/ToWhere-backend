package com.zucc.edu.javen.tw.service;

import com.zucc.edu.javen.tw.entity.KindEntity;
import com.zucc.edu.javen.tw.service.impl.KindServiceImpl;
import com.zucc.edu.javen.tw.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class KindService implements KindServiceImpl {
    @Override
    public List<KindEntity> loadKind() {

        SqlSession session = MyBatiesUtil.getSession();
        List<KindEntity> list = session.selectList("loadKind");
        return list;
    }
}
