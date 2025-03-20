package com.cheeseocean.community.entity;

import com.cheeseocean.common.entity.BasicEntity;
import com.cheeseocean.common.enums.ResourceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_star")
public class Star extends BasicEntity {

    private Long uid;

    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "resource_type")
    @Enumerated
    private ResourceType resourceType;

    private Star(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setUid(builder.uid);
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
        private Long          id;
        private String        remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Long          uid;
        private Long          resourceId;
        private ResourceType  resourceType;

        private Builder() {
        }

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

        public Builder resourceId(Long val) {
            resourceId = val;
            return this;
        }

        public Builder resourceType(ResourceType val) {
            resourceType = val;
            return this;
        }

        public Star build() {
            return new Star(this);
        }
    }
}
