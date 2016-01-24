package opensource.onlinestore.model.dto;

import opensource.onlinestore.model.Category;
import opensource.onlinestore.model.entity.CategoryEntity;

public class GoodsDTO {
    private String name;
    private Double price;
    private Long count;
    private CategoryEntity category;
    private String producer;
    private String charachteristics;

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

    public String getCharachteristics() {
        return charachteristics;
    }

    public void setCharachteristics(String charachteristics) {
        this.charachteristics = charachteristics;
    }
}
