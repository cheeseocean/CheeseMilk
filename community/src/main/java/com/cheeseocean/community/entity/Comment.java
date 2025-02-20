package com.cheeseocean.community.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.cheeseocean.common.entity.BasicEntity;
import com.cheeseocean.common.enums.ResourceType;

@Entity(name = "Comment")
@Table(name = "tbl_comment")
@DynamicUpdate
@DynamicInsert
public class Comment extends BasicEntity {

    private Long uid;
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    private String content;

    @Column(name = "resource_id")
    private Long resourceId;

    @Enumerated
    @Column(name = "resource_type")
    private ResourceType resourceType;

    private Comment(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setUid(builder.uid);
        setParent(builder.parent);
        setContent(builder.content);
        setResourceId(builder.resourceId);
        setResourceType(builder.resourceType);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }


    public static final class Builder {
        private Long id;
        private String remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Long uid;
        private Comment parent;
        private String content;
        private Long resourceId;
        private ResourceType resourceType;

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

        public Builder parent(Comment val) {
            parent = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder resourceId(Long val) {
            resourceId = val;
            return this;
        }

        public Builder resourceType(ResourceType val) {
            resourceType = val;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }
}
