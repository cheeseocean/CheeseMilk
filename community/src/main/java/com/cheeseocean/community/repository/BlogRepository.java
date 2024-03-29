package com.cheeseocean.community.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cheeseocean.community.entity.Blog;
import com.cheeseocean.community.entity.Category;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> getAllByCategory(Category category, Pageable pageable);

    Page<Blog> getAllByCategoryAndCreatedAtAfterAndCreatedAtBefore(Category category, LocalDateTime start, LocalDateTime end, Pageable pageable);

//    @Modifying
//    @Query("update Blog p set p.commentCount = p.commentCount + :increment where p.id = :pid")
//    void updateComments(@Param("pid") Long pid, @Param("increment") int increment);

//    @Modifying
//    @Query("update Blog p set p.starCount = p.starCount + :increment where p.id = :pid")
//    void updateStars(@Param("pid") Long pid, @Param("increment") int increment);

//    @EntityGraph(attributePaths = {"posts"}, type = EntityGraph.EntityGraphType.FETCH)
//    User findByNickname(String nickname);
//
//    @EntityGraph("User.postsFetchAll")
//    @Query("select u from User u where u.nickname = :nickname")
//    User fetchAllByNickname(@Param("nickname") String nickname);
//
//    @EntityGraph("User.postsFetchImages")
//    User getByNickname(String nickname);
}
