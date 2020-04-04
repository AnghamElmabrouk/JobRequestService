package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class JobRequest {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;

        private String firstname;

        private String lastname;

        private String telephone;

        private String email;

        public long getId() {
        return id;
    }

        public String getEmail() {
        return email;
    }

        public void setFirstname(String firstname) {
        this.firstname = firstname;
        }

        public void setLastname(String lastname) {
        this.lastname = lastname;
         }

        public String getFirstname() {
        return firstname;
        }

        public String getLastname() {
        return lastname;
        }



        public void setTelephone(String telephone) {
        this.telephone = telephone;
        }

        public String getTelephone() {
        return telephone;
        }



        public void setId(long id) {
        this.id = id;
    }

        public void setEmail(String email) {
        this.email = email;
    }


}
