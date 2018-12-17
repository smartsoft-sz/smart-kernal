package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.CodeGroup;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CodeGroupMapper extends Mapper<CodeGroup> {

    List<CodeGroup> filter(@Param("keyword") String keyword);
}