package com.example.CRUDMicroservice.Controller;

import com.example.CRUDMicroservice.Model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoursesController {

    private List<Course> courses;

    @PostConstruct
    public void init() {
        courses = new ArrayList<>();
        courses.add(new Course("Spring", 25, "Tuesday"));
        courses.add(new Course("Spring Boot", 40, "Wednesday"));
        courses.add(new Course("Python", 50, "Thursday"));
        courses.add(new Course("Java", 50, "Monday"));
        courses.add(new Course("Java 2", 50, "Monday"));
    }

    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourse() {
        return new Course("Java", 100, "Monday");
    }

    @GetMapping(value = "courses/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourse(@PathVariable(name = "name") String name) {

        List<Course> aux = new ArrayList<>();
        for (Course c : courses) {
            if (c.getName().contains(name)) {
                aux.add(c);
            }
        }
        return aux;
    }

    @DeleteMapping(value = "course/{name}")
    public void delete(@PathVariable(name = "name")String name){
        courses.removeIf(c -> c.getName().equals(name));
    }

    @PostMapping(value = "course",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> addCourse(@RequestBody Course course){
        courses.add(course);
        return courses;
    }

    @PutMapping(value = "course",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> updateCourse(@RequestBody Course course){
        for(int i = 0; i<courses.size(); i++){
            if(courses.get(i).getName().equals(course.getName())){
                courses.set(i, course);
            }
        }
        return courses;
    }

}