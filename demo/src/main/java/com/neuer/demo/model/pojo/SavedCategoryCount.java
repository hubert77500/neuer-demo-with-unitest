package com.neuer.demo.model.pojo;

import java.io.Serializable;
import java.util.Objects;

public class SavedCategoryCount implements Serializable {
    private final static long serialVersionUID = 5700050892536960583L;
    private String category;
    private int count;

    public SavedCategoryCount(String category, int count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedCategoryCount)) return false;
        SavedCategoryCount that = (SavedCategoryCount) o;
        return getCount() == that.getCount() &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getCount());
    }

    @Override
    public String toString() {
        return "SavedCategoryCount{" +
                "category='" + category + '\'' +
                ", count=" + count +
                '}';
    }

}
