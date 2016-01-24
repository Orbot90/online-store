package opensource.onlinestore.model.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import opensource.onlinestore.model.Category;
import opensource.onlinestore.model.type.StringJsonUserType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Map;

@TypeDefs( {@TypeDef( name= "StringJsonObject", typeClass = StringJsonUserType.class)})
@Entity
@Table(name = "GOODS")
public class GoodsEntity {

    @Transient
    private static final Logger LOG = LoggerFactory.getLogger(GoodsEntity.class);

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long count;
    @NotNull
    @OneToOne
    private CategoryEntity category;
    @NotNull
    private Double price;
    @NotNull
    private String producer;
    @Type(type = "StringJsonObject")
    private String charachteristics;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Map<String,String> getCharachteristicsAsMap() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> characteristic = null;
        try {
            characteristic = mapper.readValue(charachteristics, new TypeReference<Map<String, String>>(){});
        } catch (IOException e) {
            LOG.error("Could not parse json", e);
        }
        return characteristic;
    }


    public void setCharachteristicsFromMap(Map<String, String> charachteristics) {
        ObjectMapper mapper = new ObjectMapper();
        String characteristic = "";
        try {
            characteristic = mapper.writeValueAsString(charachteristics);
        } catch (JsonProcessingException e) {
            LOG.error("Could not make json from map", e);
        }
        this.charachteristics = characteristic;
    }


    public String getCharachteristics() {
        return charachteristics;
    }

    public void setCharachteristics(String charachteristics) {
        this.charachteristics = charachteristics;
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

    public boolean isNew() {
        return id == null;
    }
}
