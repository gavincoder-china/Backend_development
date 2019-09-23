package gavin.code.mapper;

import gavin.code.dto.Orderitems;

public interface OrderitemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderitems record);

    int insertSelective(Orderitems record);

    Orderitems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderitems record);

    int updateByPrimaryKey(Orderitems record);
}