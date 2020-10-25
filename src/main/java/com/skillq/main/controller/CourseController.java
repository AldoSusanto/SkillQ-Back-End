package com.skillq.main.controller;

import com.skillq.main.model.entity.Course;
import com.skillq.main.model.entity.UserCourse;
import com.skillq.main.model.request.GetUserCurrentChapterRequest;
import com.skillq.main.repository.CourseRepository;
import com.skillq.main.repository.UserCourseRepository;
import com.skillq.main.util.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    private CourseRepository courseRepository;
    private UserCourseRepository userCourseRepository;

    public CourseController(CourseRepository courseRepository, UserCourseRepository userCourseRepository) {
        this.courseRepository = courseRepository;
        this.userCourseRepository = userCourseRepository;
    }

    @GetMapping("/")
    private List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{courseId}")
    private Course getCourseById(@RequestBody String courseId){
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "00004", "Course with course ID: " + courseId + " not found"));
    }

    @GetMapping("/current/chapter/")
    private UserCourse getCurrentChapterOfUser(@Valid @RequestBody GetUserCurrentChapterRequest request){
        return userCourseRepository.findByUsernameAndCourseId(request.getUsername(), request.getCourseId())
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "00005", "User_Course with username: " + request.getUsername() + "and courseId: " + request.getCourseId() + " not found"));
    }





}
