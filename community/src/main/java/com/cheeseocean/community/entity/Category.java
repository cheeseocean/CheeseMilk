package com.cheeseocean.community.entity;

import java.time.LocalDateTime;

import com.cheeseocean.common.entity.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category extends BasicEntity {

    private String categoryName;

    private String description;

    private String avatarUrl;

    public Category(){}

    private Category(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setCategoryName(builder.categoryName);
        setDescription(builder.description);
        setAvatarUrl(builder.avatarUrl);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }


    public static final class Builder {
        private Long id;
        private String remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String categoryName;
        private String description;
        private String avatarUrl;

        private Builder() {}

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder remark(String val) {
            remark = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder categoryName(String val) {
            categoryName = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder avatarUrl(String val) {
            avatarUrl = val;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
