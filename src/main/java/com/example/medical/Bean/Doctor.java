package com.example.medical.Bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid2")
    private String Id;
    private String name;
    private String qualificatio;
    private String specialist;

    public Doctor() {
    }

    public Doctor(String name, String qualificatio, String specialist) {
        this.name = name;
        this.qualificatio = qualificatio;
        this.specialist = specialist;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualificatio() {
        return qualificatio;
    }

    public void setQualificatio(String qualificatio) {
        this.qualificatio = qualificatio;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
}
