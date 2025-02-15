package com.cheeseocean.community.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.cheeseocean.common.entity.BasicEntity;

@Entity
@Table(name = "tbl_blog")
@DynamicUpdate
@DynamicInsert
public class Blog extends BasicEntity {

    private Long uid;

    private String content;

    /**
     * 标签，使用逗号分开
     */
    private String tags;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private BlogPrivacy privacy;

    private Blog(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setUid(builder.uid);
        setContent(builder.content);
        setTags(builder.tags);
        setCategory(builder.category);
        setPrivacy(builder.privacy);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public enum BlogPrivacy {
        PUBLIC, ONLY_ME, ONLY_FRIEND, ONLY_FOLLOWER
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BlogPrivacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(BlogPrivacy privacy) {
        this.privacy = privacy;
    }

    public static final class Builder {
        private Long id;
        private String remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Long uid;
        private String content;
        private String tags;
        private Category category;
        private BlogPrivacy privacy;

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

        public Builder uid(Long val) {
            uid = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder tags(String val) {
            tags = val;
            return this;
        }

        public Builder category(Category val) {
            category = val;
            return this;
        }

        public Builder privacy(BlogPrivacy val) {
            privacy = val;
            return this;
        }

        public Blog build() {
            return new Blog(this);
        }
    }
}