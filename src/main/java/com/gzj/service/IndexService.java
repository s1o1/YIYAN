package com.gzj.service;

import java.util.Map;

public interface IndexService {
    /**
     *              分页查询（默认6条记录）
     * @param index 起始页
     * @return      查询结果以及index
     */
    Map<String,Object> getPics(int index);
}
