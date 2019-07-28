package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project: 完成查询
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 10:49
 * @description:
 ************************************************************/
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询

        return dao.findAll();
    }

    @Override
    public Integer add(User user) {
        UserDao dao = new UserDaoImpl();
        Integer add = dao.add(user);
        return add;
    }

    @Override
    public Integer del(Integer id) {
        UserDao dao = new UserDaoImpl();
        Integer del = dao.del(id);
        return del;
    }

    @Override
    public User findOne(Integer id) {
        UserDao dao = new UserDaoImpl();
        User user = dao.findOne(id);
        return user;
    }

    @Override
    public Integer update(User user) {
        UserDao dao = new UserDaoImpl();
        Integer updateResult = dao.update(user);
        return updateResult;
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        //1.创建一个pagebean对象
        PageBean<User> pageBean = new PageBean<>();
        //2.设置参数,当前页码,每页显示数
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //3.调用dao查询总记录数
       int totalCount= dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);

        //4.调用dao查询list集合,传两个参数,一个是开始的记录索引start,一个是rows

        int start=(currentPage-1)*rows;

        List<User> list= dao.findByPage(start,rows,condition);

        pageBean.setList(list);
        //5.设置总页数
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows + 1);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
