package com.cheeseocean.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.cheeseocean.core.entity.Course;
import com.cheeseocean.core.entity.UserInfo;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByUserInfo(UserInfo userInfo);

    @Modifying
    void deleteAllByUserInfo(UserInfo userInfo);

}
