package com.gavin.provider.mapper;

import com.gavin.provider.dto.SecSucess;
import org.apache.ibatis.annotations.Param;

public interface SecSucessMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecSucess record);

    int insertSelective(SecSucess record);

    SecSucess selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecSucess record);

    int updateByPrimaryKey(SecSucess record);

    int updateStatebyid(@Param("updatedState") Byte updatedState, @Param("id") Long id);





   Long selectidByUserIdAndState(@Param("userId") Long userId, @Param("state") Byte state);


   Long selectProIdById(@Param("id") Long id);





}