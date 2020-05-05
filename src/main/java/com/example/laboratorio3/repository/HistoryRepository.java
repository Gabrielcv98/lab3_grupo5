package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HistoryRepository extends JpaRepository<JobHistory, Integer > {


}
