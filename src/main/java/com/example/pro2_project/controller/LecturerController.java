package com.example.pro2_project.controller;

import com.example.pro2_project.model.Lecturer;
import com.example.pro2_project.repository.LecturerRepository;
import com.example.pro2_project.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "lecturers_list";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id) {
        model.addAttribute("lecturer", lecturerService.getLecturer(id));
        return "lecturers_detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("lecturer", lecturerService.getLecturer(id));
        return "lecturers_delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteConfirm(Model model, @PathVariable long id) {
        lecturerService.deleteLecturer(id);
        return "redirect:/lecturers/";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "lecturers_add";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("lecturer", lecturerService.getLecturer(id));
        return "lecturers_add";
    }

    @PostMapping("/save")
    public String addSave(@ModelAttribute Lecturer lecturer) {
        lecturerService.saveLecturer(lecturer);
        return "redirect:/lecturers/";
    }

}
