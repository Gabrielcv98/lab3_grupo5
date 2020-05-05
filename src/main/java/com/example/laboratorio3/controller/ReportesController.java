package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Reportes")
public class ReportesController {
    @Autowired
    EmployeesRepository employeesRepository;




    @GetMapping(value = {"/reporte1"})
    public String primerReporte(Model model){
        model.addAttribute("listaReporte1", employeesRepository.obtenerEmpleadosConMayorSalario());
        return "Search/listaR1";
    }
    @GetMapping(value = {"/reporte2"})
    public String segundoReporte(Model model){
        model.addAttribute("listaReporte2", employeesRepository.obtenerDepasconmenora3());
        return "Search/listaR2";
    }

}
