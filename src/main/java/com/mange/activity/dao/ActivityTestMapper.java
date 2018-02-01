package com.mange.activity.dao;

import com.mange.activity.dao.sqlbuilder.ActivityTestSqlBuilder;
import com.mange.activity.domain.ActivityTest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create by lbm on 2017/11/10
 *
 * @author lbm
 */
@Mapper
@Component
public interface ActivityTestMapper {
    @Insert("insert into activity_test(name) values(#{name})")
    int add(ActivityTest test);

    @Update("update activity_test set name=#{name}")
    int update(ActivityTest test);

    @DeleteProvider(type = ActivityTestSqlBuilder.class, method = "deleteByIds")
    int deleteByIds(String[] ids);

    @Select("select * from activity_test where uid=#{id}")
    @Results(id = "testMap", value = {@Result(column = "uid", property = "uid", javaType = Long.class), @Result(column = "name", property = "name", javaType = String.class)})
    ActivityTest queryTestById(Long id);

    @SelectProvider(type = ActivityTestSqlBuilder.class, method = "queryTestById")
    List<ActivityTest> queryTestList(Map<String, Object> params);
}
