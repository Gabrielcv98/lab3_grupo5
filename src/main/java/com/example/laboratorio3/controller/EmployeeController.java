package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Department;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.Job;
import com.example.laboratorio3.repository.DepartmentRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employee")
//COMPLETAR
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    JobRepository jobRepository;

    @GetMapping(value = {"", "/lista"})
    public String listaEmployee(Model model) {

        List<Employees> lista = employeesRepository.findAll();
        model.addAttribute("listaEmployee", lista);

        return "employee/lista";
    }

    public String nuevoEmployeeForm(Model model) {

        List<Department> listaDepart = departmentRepository.findAll();
        List<Job> listaJob = jobRepository.findAll();
        List<Employees> listaJefes = employeesRepository.findAll();
        model.addAttribute("listaDepart", listaDepart);
        model.addAttribute("listaJob", listaJob);
        model.addAttribute("listaJefes", listaJefes);

        return "employee/newFrm";
    }


    public String guardarEmployee(Employees employees, RedirectAttributes attr) {

        attr.addFlashAttribute("mensaje", "")
        employeesRepository.save(employees);


        return "";
    }


    public String editarEmployee() {
        //COMPLETAR
        return "";
    }


    public String borrarEmpleado() {

        //COMPLETAR
    return "";
    }

    //COMPLETAR

}

