package Entity;

import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:  图书信息实体类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 09:05
 * @description:
 ************************************************************/
public class BookInfo {



    private Integer bookId ;
    /** book_code */
    private String bookCode ;
    /** bood_name */
    private String bookName ;
    /** book_type */
    private String bookType ;
    /** book_author */
    private String bookAuthor ;
    /** publish_press */
    private String publishPress ;
    /** publish_date */
    private Date publishDate ;
    /** is_borrow */
    private Integer isBorrow ;
    /** createdBy */
    private String createdby ;
    /** creation_time */
    private Date creationTime ;
    /** last_updatetime */
    private Date lastUpdatetime ;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Integer isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(Date lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }

    @Override
    public String toString() {

        return "BookInfo{" +
               "bookId=" + bookId +
               ", bookCode='" + bookCode + '\'' +
               ", bookName='" + bookName + '\'' +
               ", bookType='" + bookType + '\'' +
               ", bookAuthor='" + bookAuthor + '\'' +
               ", publishPress='" + publishPress + '\'' +
               ", publishDate=" + publishDate +
               ", isBorrow=" + isBorrow +
               ", createdby='" + createdby + '\'' +
               ", creationTime=" + creationTime +
               ", lastUpdatetime=" + lastUpdatetime +
               '}';


}}
