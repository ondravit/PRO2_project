package com.example.pro2_project.controller;

import com.example.pro2_project.model.Course;
import com.example.pro2_project.service.CourseService;
import com.example.pro2_project.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final LecturerService lecturerService;

    @Autowired
    public CourseController(CourseService courseService, LecturerService lecturerService) {
        this.courseService = courseService;
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses_list";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id) {
        model.addAttribute("course", courseService.getCourse(id));
        return "courses_detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("course", courseService.getCourse(id));
        return "courses_delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteConfirm(Model model, @PathVariable long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "courses_add";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "courses_add";
    }

    @PostMapping("/save")
    public String addSave(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses/";
    }

}
