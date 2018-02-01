package com.mange.activity.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.mange.activity.vo.ModelView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Create by lbm on 2017/11/10
 * @author lbm
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Table {
    @JsonView(ModelView.Table.class)
    private Long id;
    @JsonView(ModelView.Table.class)
    private String tableName;
}
