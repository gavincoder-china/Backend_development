package main.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import main.Entity.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    List<Book> selectAll();



}