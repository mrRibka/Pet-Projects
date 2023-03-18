package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private StudentService studentService;

    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

   /* @GetMapping("/students")
    public String listStudents(Model model, @Param("keyword") String keyword){

        model.addAttribute("students", studentService.getAllStudents(keyword));
        model.addAttribute("keyword", keyword);
        return "students";
    }*/

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }
    @PostMapping("/students/update/{id}")
    public String addUpdate(@ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @Param("keyword") String keyword) {

        Page<Student> page = studentService.listAll(pageNum, keyword);

        List<Student> students = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword);

        return "students";
    }
    @GetMapping("/students")
    public String viewHomePage(Model model) {
        return viewPage(model, 1, null);
    }

    @GetMapping("/students/search")
    public String viewSearch(Model model,
                                @Param("keyword") String keyword) {
        return viewPage(model, 1, keyword);
    }
}
