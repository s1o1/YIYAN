package com.gzj.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pic {
    private Integer id;
    private String name;
    private Timestamp createTime;
    private String suffix;
    private String url;
    private String type;
}
