package opensource.onlinestore.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "GOODS")
public class GoodsEntity extends BaseEntity {
    @NotNull
    private String name;
    @NotNull
    private Long count;
    @NotNull
    @ManyToOne
    private CategoryEntity category;
    @NotNull
    private Double price;
    @NotNull
    private String producer;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
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
