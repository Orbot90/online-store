package opensource.onlinestore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "goods")
public class GoodsEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "article", nullable = false)
    private String article;

    @NotNull
    @Column(name = "count", nullable = false)
    private Long count;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @Column(name = "producer", nullable = false)
    private String producer;

    //TODO ?????
    @Transient
    private byte[] image;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "goods_messages",
            joinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "messages_id", referencedColumnName = "id"))
    private List<MessageEntity> opinions;

    public GoodsEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<MessageEntity> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<MessageEntity> opinions) {
        this.opinions = opinions;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (article != null ? !article.equals(that.article) : that.article != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (producer != null ? !producer.equals(that.producer) : that.producer != null) return false;
        if (!Arrays.equals(image, that.image)) return false;
        return opinions != null ? opinions.equals(that.opinions) : that.opinions == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (opinions != null ? opinions.hashCode() : 0);
        return result;
    }
}
