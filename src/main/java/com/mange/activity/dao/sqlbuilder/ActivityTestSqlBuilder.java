package com.mange.activity.dao.sqlbuilder;

import com.github.pagehelper.util.StringUtil;

import java.util.Map;

/**
 * Create by lbm on 2017/11/10
 * @author lbm
 */
public class ActivityTestSqlBuilder {

    public String queryTestById(final Map<String, Object> params){
        StringBuffer sql =new StringBuffer();
        sql.append("select * from activity_test where 1=1");
        if(!StringUtil.isNotEmpty((String)params.get("name"))){
            sql.append(" and name like '%").append((String)params.get("name")).append("%'");
        }
        System.out.println("查询sql=="+sql.toString());
        return sql.toString();
    }

    public String deleteByIds(String[] ids){
        StringBuffer sql =new StringBuffer();
        sql.append("delete from activity_test where id in(");
        for (int i=0;i<ids.length;i++){
            if(i==ids.length-1){
                sql.append(ids[i]);
            }else{
                sql.append(ids[i]).append(",");
            }
        }
        sql.append(")");
        return sql.toString();
    }
}
