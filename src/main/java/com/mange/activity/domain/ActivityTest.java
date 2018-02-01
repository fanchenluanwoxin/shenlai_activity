package com.mange.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Create by lbm on 2017/11/10
 * @author lbm
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityTest {
    private Long uid;
    private String name;
    private Date create_time;
    private Date update_time;
}
