package Entity;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-15 11:16
 * @description:
 ************************************************************/
public class Book2 {
    private Integer id;
    private String content;

    @Override
    public String toString() {
        return "Book{" +
               "id=" + id +
               ", content='" + content + '\'' +
               '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
