package com.cheeseocean.core.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cheeseocean.common.entity.BasicEntity;

@Entity(name = "User")
@Table(name = "tbl_user")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class UserInfo extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 749792921653839187L;

    private String username;

    private String nickname;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    //eg:0793-江西上饶、0731-湖南长沙
    private String location = null;

    private String bio;

    private LocalDateTime birth;

    //0-male, 1-female
    private Integer gender;

    @OneToMany
    @JoinTable(name = "tbl_user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            })
    private Set<Role> roles;

    public UserInfo(){}
    private UserInfo(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setUsername(builder.username);
        setNickname(builder.nickname);
        setStatus(builder.status);
        setEmail(builder.email);
        setAvatarUrl(builder.avatarUrl);
        setLocation(builder.location);
        setBio(builder.bio);
        setBirth(builder.birth);
        setGender(builder.gender);
        setRoles(builder.roles);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public enum UserStatus {
        ENABLE, OFFLINE, ONLINE, DISABLED, ACCOUNT_LOCKED
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public static final class Builder {
        private Long id;
        private String remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String username;
        private String nickname;
        private UserStatus status;
        private String email;
        private String avatarUrl;
        private String location;
        private String bio;
        private LocalDateTime birth;
        private Integer gender;
        private Set<Role> roles;

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

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder nickname(String val) {
            nickname = val;
            return this;
        }

        public Builder status(UserStatus val) {
            status = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder avatarUrl(String val) {
            avatarUrl = val;
            return this;
        }

        public Builder location(String val) {
            location = val;
            return this;
        }

        public Builder bio(String val) {
            bio = val;
            return this;
        }

        public Builder birth(LocalDateTime val) {
            birth = val;
            return this;
        }

        public Builder gender(Integer val) {
            gender = val;
            return this;
        }

        public Builder roles(Set<Role> val) {
            roles = val;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }
}
