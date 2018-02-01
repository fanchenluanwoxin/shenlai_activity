package com.mange.activity.service;

import com.mange.activity.domain.ActivityTest;

import java.util.List;
import java.util.Map;

/**
 * Create by lbm on 2017/11/10
 *
 * @author lbm
 */
public interface ActivityTestService {
    int add(ActivityTest test);
    int update(ActivityTest test);
    int deleteByIds(String[] ids);
    ActivityTest queryTestById(Long id);
    List<ActivityTest> queryTestList(Map<String, Object> params);
}
