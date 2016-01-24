package opensource.onlinestore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CATEGORIES",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class CategoryEntity extends BaseEntity {

    @NotNull
    private String name;
    @OneToOne
    private CategoryEntity parent;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return !(getParent() != null ? !getParent().equals(that.getParent()) : that.getParent() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
        return result;
    }
}
