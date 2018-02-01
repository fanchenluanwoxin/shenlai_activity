package com.mange.activity.service.imp;

import com.github.pagehelper.PageHelper;
import com.mange.activity.dao.ActivityTestMapper;
import com.mange.activity.domain.ActivityTest;
import com.mange.activity.service.ActivityTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Create by lbm on 2017/11/10
 * @author lbm
 */
@Service
public class ActivityTestServiceImp implements ActivityTestService {
    @Autowired
    ActivityTestMapper mapper;
    @Autowired
    JedisPool jedisPool;

    @Override
    public int add(ActivityTest test) {
//        String uuid = UUID.randomUUID().toString();
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(test.getName(), test.getName());
        }
        return mapper.add(test);
    }

    @Override
    public int update(ActivityTest test) {
        return mapper.update(test);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public ActivityTest queryTestById(Long id) {
        return mapper.queryTestById(id);
    }

    @Override
    public List<ActivityTest> queryTestList(Map<String, Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return mapper.queryTestList(params);
    }
}
