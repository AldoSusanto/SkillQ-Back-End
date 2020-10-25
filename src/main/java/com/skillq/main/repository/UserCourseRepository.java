package com.skillq.main.repository;

import com.skillq.main.model.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCourseRepository extends JpaRepository<UserCourse, String> {

    Optional<UserCourse> findByUsernameAndCourseId(String username, String courseId);
}
