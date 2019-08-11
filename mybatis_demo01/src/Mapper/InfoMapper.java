package Mapper;

import Mapper.Info;

public interface InfoMapper {
    int insert(Info record);

    int insertSelective(Info record);

}