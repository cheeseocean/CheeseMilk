package com.cheeseocean.core.entity;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.cheeseocean.common.entity.BasicEntity;
import com.cheeseocean.common.exception.UnexpectedException;

@Entity
@Table(name = "tbl_user_auth")
public class UserAuth extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @Convert(converter = IdentityTypeConverter.class)
    @Column(name = "identify_type")
    private IdentityType identifyType;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "credential")
    private String credential;

    @Column(name = "bind_flag")
    private boolean bindFlag;

    public UserAuth(){}

    private UserAuth(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setUserInfo(builder.userInfo);
        setIdentifyType(builder.identifyType);
        setIdentifier(builder.identifier);
        setCredential(builder.credential);
        setBindFlag(builder.bindFlag);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public enum IdentityType{
        USERNAME("username"),
        EMAIL("email"),
        PHONE("phone"),
        WECHAT("wechat"),
        QQ("qq"),
        GITHUB("github");

        private final String typeName;
        IdentityType(String typeName){
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

        public static IdentityType from(String value){
            for (IdentityType identityType : IdentityType.values()) {
                if (identityType.typeName.equals(value)){
                    return identityType;
                }
            }
            throw new UnexpectedException("Not supported IdentityType");
        }
    }
    static class IdentityTypeConverter implements AttributeConverter<IdentityType, String>{
        @Override
        public String convertToDatabaseColumn(IdentityType attribute) {
            return attribute.typeName;
        }

        @Override
        public IdentityType convertToEntityAttribute(String dbData) {
            return IdentityType.from(dbData);
        }
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public IdentityType getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(IdentityType identifyType) {
        this.identifyType = identifyType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public boolean isBindFlag() {
        return bindFlag;
    }

    public void setBindFlag(boolean bindFlag) {
        this.bindFlag = bindFlag;
    }


    public static final class Builder {
        private Long id;
        private String remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserInfo userInfo;
        private IdentityType identifyType;
        private String identifier;
        private String credential;
        private boolean bindFlag;

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

        public Builder userInfo(UserInfo val) {
            userInfo = val;
            return this;
        }

        public Builder identifyType(IdentityType val) {
            identifyType = val;
            return this;
        }

        public Builder identifier(String val) {
            identifier = val;
            return this;
        }

        public Builder credential(String val) {
            credential = val;
            return this;
        }

        public Builder bindFlag(boolean val) {
            bindFlag = val;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}
