package th.mfu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="displayname")
    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDate birthday;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleOrder> saleOrders = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews = new ArrayList<>();

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<SaleOrder> getSaleOrders() {
        return saleOrders;
    }
    public void setSaleOrders(List<SaleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }
    public List<ProductReview> getReviews() {
        return reviews;
    }
    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }
}


