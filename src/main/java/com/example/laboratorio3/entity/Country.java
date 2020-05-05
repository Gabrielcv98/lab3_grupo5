package com.example.laboratorio3.entity;

import javax.persistence.*;




@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id")
    private String country_id;
    @Column(name = "country_name", nullable = false)
    private String country_name;

    @ManyToOne
    @JoinColumn(name = "region_id" )
    private Region region;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
