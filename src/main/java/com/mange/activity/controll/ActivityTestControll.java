package com.mange.activity.controll;

import com.mange.activity.domain.ActivityTest;
import com.mange.activity.service.ActivityTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by lbm on 2017/11/10
 *
 * @author lbm
 */
@RestController
@RequestMapping("/test")
public class ActivityTestControll {
    Logger logger = LoggerFactory.getLogger(ActivityTestControll.class);

    @Autowired
    ActivityTestService service;

    @RequestMapping("/add")
    public Integer add(ActivityTest test){
        return service.add(test);
    }

    @RequestMapping("/update")
    public Integer update(ActivityTest test){
        return service.update(test);
    }

    @RequestMapping("/deleteByIds")
    public Integer deleteByIds(String ids){
        int index = service.deleteByIds(ids.split(","));
        return index;
    }
    @RequestMapping("/queryTestById")
    public ActivityTest queryTestById(Long id){
        logger.info("queryTestById");
        return service.queryTestById(id);
    }

    @RequestMapping("/queryTestList")
    public List<ActivityTest> queryTestList(String name, Integer page, Integer rows){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("name", name);
        return service.queryTestList(params);
    }
}
