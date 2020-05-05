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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Job> listaJob = jobRepository.findAll();
        model.addAttribute("listaEmployee", lista);
        model.addAttribute("listaJob", listaJob);

        return "employee/lista";
    }
    @GetMapping("nuevo")
    public String nuevoEmployeeForm(Model model) {

        List<Department> listaDepart = departmentRepository.findAll();
        List<Job> listaJob = jobRepository.findAll();
        List<Employees> listaJefes = employeesRepository.findAll();
        model.addAttribute("listaDepart", listaDepart);
        model.addAttribute("listaJob", listaJob);
        model.addAttribute("listaJefes", listaJefes);

        return "employee/newFrm";
    }

    @PostMapping("nuevo")
    public String guardarEmployee(Employees employees, RedirectAttributes attr) {

        attr.addFlashAttribute("mensaje", "");
        employeesRepository.save(employees);


        return "";
    }

    @GetMapping("editar")
    public String editarEmployee(@RequestParam("id") Integer employeeId, Model model, RedirectAttributes attr) {

        Optional<Employees> opt = employeesRepository.findById(employeeId);

        if (opt.isPresent()) {
            Employees e = opt.get();
            if (e.getManager() == null) {
                attr.addFlashAttribute("msg", "Esta acción no está soportada por el momento para Empleados sin jefe");
                return "redirect:/employee";
            } else {
                model.addAttribute("employee", e);
                model.addAttribute("listaJobs", jobRepository.findAll());
                model.addAttribute("listaJefes", employeesRepository.findAll());
                return "employee/editForm";
            }
        } else {
            return "redirect:/employee";
        }
    }


    public String borrarEmpleado(@RequestParam("id")Integer employeeId, RedirectAttributes attr) {
        employeesRepository.deleteById(employeeId);
        attr.addFlashAttribute("msg", "Empleado borrado exitosamente");
        return "redirect:/employee";
    }

    //COMPLETAR

}

