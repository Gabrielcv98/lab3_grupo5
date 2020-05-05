package com.example.laboratorio3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_history")
public class JobHistory {

    @Id
    @Column(nullable=false)
    private int jobHistoryId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @Column(nullable=false)
    private Employees employeeId;

    @Column(nullable=false)
    private Date startDate;

    @Column(nullable=false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job jobId;

    public int getJobHistoryId() {
        return jobHistoryId;
    }

    public void setJobHistoryId(int jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentId;





}
