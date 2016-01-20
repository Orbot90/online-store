package opensource.onlinestore.model.entity;

import opensource.onlinestore.model.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "GOODS")
public class GoodsEntity extends BaseEntity{

    @NotNull
    private String name;
    @NotNull
    private Long count;
    @NotNull
    private Category category;
    @NotNull
    private Double price;
    @NotNull
    private String producer;

    @ManyToOne(fetch = FetchType.LAZY,optional=true)
    @JoinTable(name = "CATALOG", joinColumns = @JoinColumn(name = "ID_BOOK"), inverseJoinColumns = @JoinColumn(name = "ID_STUDENT"))
    private Order order;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

}
