package th.mfu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private LocalDate manufactureDate;

    @OneToMany(mappedBy = "product")
    private List<SaleOrderItem> saleOrderItems = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews = new ArrayList<>();
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    public List<SaleOrderItem> getSaleOrderItems() {
        return saleOrderItems;
    }
    public void setSaleOrderItems(List<SaleOrderItem> saleOrderItems) {
        this.saleOrderItems = saleOrderItems;
    }
    public List<ProductReview> getReviews() {
        return reviews;
    }
    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }
    
}


