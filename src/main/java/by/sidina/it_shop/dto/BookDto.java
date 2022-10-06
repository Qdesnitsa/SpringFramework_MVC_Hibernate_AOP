package by.sidina.it_shop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BookDto {
    private long id;
    @NotBlank(message = "all fields are mandatory")
    @Size(min = 1, max = 100, message = "name should be between 2 and 100 symbols")
    private String name;
    @NotBlank(message = "all fields are mandatory")
    private String language;
    @NotBlank(message = "all fields are mandatory")
    @Pattern(regexp = "[a-zA-Z\\s]{2,100}", message = "author should be between 2 and 100 symbols")
    private String author;
    @NotBlank(message = "all fields are mandatory")
    @Pattern(regexp = "^[0-9]*[.,]?[0-9]+$", message = "numbers only")
    private String price;
    @NotBlank(message = "all fields are mandatory")
    @Pattern(regexp = "\\d+", message = "numbers only")
    private String pageNumber;
    @NotBlank(message = "all fields are mandatory")
    @Pattern(regexp = "[0-9]{4}", message = "should contain 4 numbers only")
    private String yearPublished;

    public BookDto() {
    }

    public BookDto(String name, String language, String author, String price, String pageNumber, String yearPublished) {
        this.name = name;
        this.language = language;
        this.author = author;
        this.price = price;
        this.pageNumber = pageNumber;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
