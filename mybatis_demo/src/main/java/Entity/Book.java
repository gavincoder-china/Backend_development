package Entity;

import java.math.BigDecimal;

public class Book {
    /**
     * id
     */
    private Integer id;

    /**
     * author
     */
    private String author;

    /**
     * price
     */
    private BigDecimal price;

    /**
     * content
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Book{" +
               "id=" + id +
               ", author='" + author + '\'' +
               ", price=" + price +
               ", content='" + content + '\'' +
               '}';
    }
}