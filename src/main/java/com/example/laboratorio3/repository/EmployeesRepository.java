package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.EmpleadosConMayorSalarioa1500;
import com.example.laboratorio3.dto.PaisCiudadYdptoMayorA3;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {


    @Query(value = "SELECT\n" +
            "                          e.first_name,\n" +
            "                          e.last_name,\n" +
            "\n" +
            "                          jh.start_date,\n" +
            "                          jh.end_date,\n" +
            "                          je.job_title puesto_actual\n" +
            "\n" +
            "\n" +
            "                      FROM employees e\n" +
            "                               iNNER JOIN job_history jh ON jh.employee_id = e.employee_id\n" +
            "                          inner JOIN jobs je ON e.job_id=je.job_id\n" +
            "\n" +
            "                      WHERE e.salary>15000;", nativeQuery = true)
    List<EmpleadosConMayorSalarioa1500> obtenerEmpleadosConMayorSalario();


    @Query(value = "SELECT c.country_name, l.city,count(d.department_name) AS `Cantidad`\n" +
            "FROM countries c\n" +
            "    INNER JOIN locations l ON (l.country_id = c.country_id)\n" +
            "    INNER JOIN departments d ON (d.location_id = l.location_id)\n" +
            "    INNER JOIN employees e ON (e.department_id = d.department_id)\n" +
            "GROUP BY d.department_id\n" +
            "HAVING count(d.department_id) > 3", nativeQuery = true)
    List<PaisCiudadYdptoMayorA3> obtenerDepasconmenora3();

//COMPLETAR

}
