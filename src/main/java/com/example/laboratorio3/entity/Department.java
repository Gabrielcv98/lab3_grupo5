package com.example.laboratorio3.entity;

import javax.persistence.*;



    @Entity
    @Table(name = "departments")
    public class Department {

        @Id
        @Column(name = "department_id", nullable = false)
        private int department_id;
        @Column(name = "department_name", nullable = false)
        private String departmentname;
        @Column(name = "manager_id")
        private String managerId;
        @ManyToOne
        @JoinColumn(name = "location_id")
        private Location location;


        public int getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(int department_id) {
            this.department_id = department_id;
        }

        public String getDepartmentname() {
            return departmentname;
        }

        public void setDepartmentname(String departmentname) {
            this.departmentname = departmentname;
        }

        public String getManagerId() {
            return managerId;
        }

        public void setManagerId(String managerId) {
            this.managerId = managerId;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }



    }

