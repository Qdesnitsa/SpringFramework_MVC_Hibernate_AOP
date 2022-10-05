package by.sidina.it_shop.entity.product;

import by.sidina.it_shop.entity.user.User;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("1")
public class Book extends ProductAbstract {
    @Column(name = "page_number")
    private int pageNumber;

    @Column(name = "year_published")
    private int yearPublished;

    public Book() {
    }

    public Book(String name, String language, String author, BigDecimal price, ProductStatus productStatus, User user,
                int pageNumber, int yearPublished) {
        super(name, language, author, price, productStatus, user);
        this.pageNumber = pageNumber;
        this.yearPublished = yearPublished;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getProductType() {
        return 1;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                super.toString() +
                ", pageNumber=" + pageNumber +
                ", yearPublished=" + yearPublished +
                "; ";
    }
}
