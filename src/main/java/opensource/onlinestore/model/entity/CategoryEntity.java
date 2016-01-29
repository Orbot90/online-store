package opensource.onlinestore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class CategoryEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    private CategoryEntity parent;

    @NotNull
    @Column(name = "characteristics_template", columnDefinition = "json")
    private String characteristicsTemplate;

    public CategoryEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getParent() {
        return parent;
    }

    public void setParent(CategoryEntity parent) {
        this.parent = parent;
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
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        return characteristicsTemplate != null ? characteristicsTemplate.equals(that.characteristicsTemplate) : that.characteristicsTemplate == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (characteristicsTemplate != null ? characteristicsTemplate.hashCode() : 0);
        return result;
    }
}
