package com.neuer.demo.model.pojo;

import com.neuer.demo.model.entity.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CategoryParsedResponse implements Serializable {
    private final static long serialVersionUID = 4601366663836137249L;
    private List<Data> validList;
    private List<SavedCategoryCount> savedCategoriesReport;

    public CategoryParsedResponse(List<Data> validList, List<SavedCategoryCount> savedCategoriesReport) {
        this.validList = validList;
        this.savedCategoriesReport = savedCategoriesReport;
    }

    public List<Data> getValidList() {
        return validList;
    }

    public void setValidList(List<Data> validList) {
        this.validList = validList;
    }

    public List<SavedCategoryCount> getSavedCategoriesReport() {
        return savedCategoriesReport;
    }

    public void setSavedCategoriesReport(List<SavedCategoryCount> savedCategoriesReport) {
        this.savedCategoriesReport = savedCategoriesReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryParsedResponse)) return false;
        CategoryParsedResponse that = (CategoryParsedResponse) o;
        return Objects.equals(getValidList(), that.getValidList()) &&
                Objects.equals(getSavedCategoriesReport(), that.getSavedCategoriesReport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValidList(), getSavedCategoriesReport());
    }

    @Override
    public String toString() {
        return "CategoryParsedResponse{" +
                "validList=" + validList +
                ", savedCategoriesReport=" + savedCategoriesReport +
                '}';
    }
}
