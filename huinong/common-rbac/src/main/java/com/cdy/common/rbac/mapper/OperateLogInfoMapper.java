package com.cdy.common.rbac.mapper;

import com.cdy.common.rbac.entiy.OperateLogInfo;
import java.util.List;

public interface OperateLogInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperateLogInfo record);

    OperateLogInfo selectByPrimaryKey(Integer id);

    List<OperateLogInfo> selectAll();

    int updateByPrimaryKey(OperateLogInfo record);
}