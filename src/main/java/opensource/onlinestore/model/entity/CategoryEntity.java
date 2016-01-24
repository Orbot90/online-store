package opensource.onlinestore.model.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import opensource.onlinestore.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Map;

@Entity
public class CategoryEntity {

    @Transient
    private static final Logger LOG = LoggerFactory.getLogger(CategoryEntity.class);

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private CategoryEntity parent;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category name;
    private String characteristicsTemplate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEntity getParent() {
        return parent;
    }

    public void setParent(CategoryEntity parent) {
        this.parent = parent;
    }

    public Category getName() {
        return name;
    }

    public void setName(Category name) {
        this.name = name;
    }

    public String getCharacteristicsTemplate() {
        return characteristicsTemplate;
    }

    public void setCharacteristicsTemplate(String characteristicsTemplate) {
        this.characteristicsTemplate = characteristicsTemplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (getParent() != null ? !getParent().equals(that.getParent()) : that.getParent() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return !(getCharacteristicsTemplate() != null ? !getCharacteristicsTemplate().equals(that.getCharacteristicsTemplate()) : that.getCharacteristicsTemplate() != null);

    }

    @Override
    public int hashCode() {
        int result = getParent() != null ? getParent().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCharacteristicsTemplate() != null ? getCharacteristicsTemplate().hashCode() : 0);
        return result;
    }

    public Map<String,String> getCharachteristicsAsMap() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> characteristic = null;
        try {
            characteristic = mapper.readValue(characteristicsTemplate, new TypeReference<Map<String, String>>(){});
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
        this.characteristicsTemplate = characteristic;
    }
}
