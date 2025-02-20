package com.cheeseocean.core.entity;

import com.cheeseocean.common.entity.BasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_course")
public class Course extends BasicEntity {
    private String semester;

    @Column(name = "week_num")
    private String weekNumber;

    private String className;

    private String classAddress;

    private String teacherName;

    private int start;

    private int length;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserInfo userInfo;

    public Course() {
    }

    private Course(Builder builder) {
        setId(builder.id);
        setRemark(builder.remark);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setSemester(builder.semester);
        setWeekNumber(builder.weekNumber);
        setClassName(builder.className);
        setClassAddress(builder.classAddress);
        setTeacherName(builder.teacherName);
        setStart(builder.start);
        setLength(builder.length);
        setUserInfo(builder.userInfo);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassAddress() {
        return classAddress;
    }

    public void setClassAddress(String classAddress) {
        this.classAddress = classAddress;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    public static final class Builder {
        private Long          id;
        private String        remark;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String        semester;
        private String        weekNumber;
        private String        className;
        private String        classAddress;
        private String        teacherName;
        private int           start;
        private int           length;
        private UserInfo      userInfo;

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

        public Builder semester(String val) {
            semester = val;
            return this;
        }

        public Builder weekNumber(String val) {
            weekNumber = val;
            return this;
        }

        public Builder className(String val) {
            className = val;
            return this;
        }

        public Builder classAddress(String val) {
            classAddress = val;
            return this;
        }

        public Builder teacherName(String val) {
            teacherName = val;
            return this;
        }

        public Builder start(int val) {
            start = val;
            return this;
        }

        public Builder length(int val) {
            length = val;
            return this;
        }

        public Builder userInfo(UserInfo val) {
            userInfo = val;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
