package com.example.laboratorio3.entity;

import javax.persistence.*;


    @Entity
    @Table(name = "locations")
    public class Location {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "location_id")
        private int locationid;

        @Column(name = "street_address")
        private String streetaddress;

        @Column(name = "postal_code")
        private String postalcode;

        public int getLocationid() {
            return locationid;
        }

        public void setLocationid(int locationid) {
            this.locationid = locationid;
        }

        public String getStreetaddress() {
            return streetaddress;
        }

        public void setStreetaddress(String streetaddress) {
            this.streetaddress = streetaddress;
        }

        public String getPostalcode() {
            return postalcode;
        }

        public void setPostalcode(String postalcode) {
            this.postalcode = postalcode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStateprovince() {
            return stateprovince;
        }

        public void setStateprovince(String stateprovince) {
            this.stateprovince = stateprovince;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        @Column(name = "city", nullable = false)
        private String city;
        @Column(name = "state_province")
        private String stateprovince;

        @ManyToOne
        @JoinColumn(name = "country_id")
        private Country country;

    }
