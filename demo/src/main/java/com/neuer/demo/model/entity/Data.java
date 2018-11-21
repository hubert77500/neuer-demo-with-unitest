package com.neuer.demo.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @OneToOne(cascade=CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name="sub_category")
    private String subCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return Objects.equals(getCategory(), data.getCategory()) &&
                Objects.equals(getSubCategory(), data.getSubCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getSubCategory());
    }
}
