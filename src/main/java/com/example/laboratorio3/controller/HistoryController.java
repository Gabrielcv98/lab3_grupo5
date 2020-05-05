package com.example.laboratorio3.controller;


import com.example.laboratorio3.entity.JobHistory;
import com.example.laboratorio3.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//COMPLETAR
public class HistoryController {
//COMPLETAR
@Autowired
    HistoryRepository historyRepository;

    @GetMapping(value = {"/list", ""})
    public String listarHistorial(Model model) {

        List<JobHistory> lista = historyRepository.findAll();
        model.addAttribute("lista", lista);

        return "history/listHistory";
    }

}
