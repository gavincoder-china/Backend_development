package Entity;

import java.util.List;

public class Role {
    private Integer rid;

    private String content;

    private transient  List<Users> list;

    public List<Users> getList() {
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Role{" +
               "rid=" + rid +
               ", content='" + content + '\'' +
               ", list=" + list +
               '}';
    }
}