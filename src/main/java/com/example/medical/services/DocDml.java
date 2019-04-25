package com.example.medical.services;

import com.example.medical.Bean.Doctor;
import com.example.medical.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import  java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class DocDml {
    DoctorRepo doctorRepo;

    @Autowired
    public void setDoctorRepo(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public void createDoctor(Doctor doc)
    {
        doctorRepo.save(doc);
    }

    public Doctor findDoctorByName(String name){
        return doctorRepo.findByName(name);
    }

    public  List<Doctor> findAll(){
        List<Doctor> doctors=doctorRepo.findAll();
        return doctors;
    }
}
