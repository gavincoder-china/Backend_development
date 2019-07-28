package domain;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:  分页对象
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-28 17:19
 * @description:
 ************************************************************/
public class PageBean<T> {

    //查询到的总记录数
    private  int totalCount;
    //总页码数==总记录数%每页显示条数==0?总记录数%每页显示条数:总记录数%每页显示条数+1
    private int totalPage;
    //当前页面的数据集合
    List<T> list;
    //当前页码
    private int currentPage;
    //每页显示条数
    private int rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
               "totalCount=" + totalCount +
               ", totalPage=" + totalPage +
               ", list=" + list +
               ", currentPage=" + currentPage +
               ", rows=" + rows +
               '}';
    }
}
