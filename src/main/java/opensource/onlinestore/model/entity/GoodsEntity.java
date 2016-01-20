package opensource.onlinestore.model.entity;

import opensource.onlinestore.model.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "goods")
public class GoodsEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Long count;

    @NotNull
    private Category category;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "producer")
    @NotNull
    private String producer;

    public GoodsEntity(){}

    public GoodsEntity(String name, Long count, Category category, Double price, String producer) {
        this.name = name;
        this.count = count;
        this.category = category;
        this.price = price;
        this.producer = producer;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsEntity)) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (getCategory() != that.getCategory()) return false;
        return getProducer().equals(that.getProducer());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getProducer().hashCode();
        return result;
    }

}
