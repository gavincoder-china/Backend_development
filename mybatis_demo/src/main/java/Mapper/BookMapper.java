package Mapper;
import java.util.Collection;

import Entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectByIdandauthorlike(@Param("id") Integer id, @Param("likeAuthor") String likeAuthor);

    int updateauthorandcontent(@Param("updatedAuthor") String updatedAuthor, @Param("updatedContent") String updatedContent);

   //我们来快速写个使用id查询

  List<Book> selectById(@Param("id")Integer id);

  List<Book> selectbyidin(@Param("idCollection")Collection<Integer> idCollection);




}