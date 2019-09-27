package com.yl.service.impl;

import com.yl.bean.Type;
import com.yl.dao.TypeMapper;
import com.yl.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类型接口实现类
 * @author YL
 * @date 10:52 2019/9/25
 */
@Service
public class TypeServiceImpl extends BaseServiceImpl<Type> implements TypeService {

    private TypeMapper typeMapper;

    @Resource
    public void setTypeMapper(TypeMapper typeMapper) {
        this.baseMapper=this.typeMapper = typeMapper;
    }
}
