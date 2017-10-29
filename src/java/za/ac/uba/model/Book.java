package za.ac.uba.model;

/**
 * Created by gracem on 2017/09/24.
 */

public class Book {

    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private String edition;
    private String language;
    private String category;
    private double price;
    private String status;
    private String additionalInfo;
    private String createdAt;
    private Integer sellerId;


    public Book() {}

    public Book(Integer id, String title, String author, String isbn, String edition, String language, String category,
                double price, String status, String additionalInfo, Integer sellerId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.edition = edition;
        this.language = language;
        this.category = category;
        this.price = price;
        this.status = status;
        this.additionalInfo = additionalInfo;
        this.sellerId = sellerId;
    }

    public Book(String title, String author, String isbn, String edition, String language, String category,
                double price, String status, String additionalInfo, Integer sellerId) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.edition = edition;
        this.language = language;
        this.category = category;
        this.price = price;
        this.status = status;
        this.additionalInfo = additionalInfo;
        this.sellerId = sellerId;
    }
    public Book(String title, String author, String isbn, String edition, String language, String category,
                double price, String additionalInfo) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.edition = edition;
        this.language = language;
        this.category = category;
        this.price = price;
        this.status = status;
        this.additionalInfo = additionalInfo;
        this.sellerId = sellerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}
