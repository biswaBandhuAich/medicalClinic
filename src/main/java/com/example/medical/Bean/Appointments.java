package com.example.medical.Bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;
    @OneToOne
    private User user;
    @OneToOne
    private Doctor doctor;

    public Appointments() {

    }

    public Appointments(User user, Doctor doctor) {
        this.user = user;
        this.doctor = doctor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


}
