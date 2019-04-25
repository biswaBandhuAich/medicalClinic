package com.example.medical.services;

import com.example.medical.Bean.Appointments;
import com.example.medical.Bean.Doctor;
import com.example.medical.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentDml {
    @Autowired
    public AppointmentRepo appointmentRepo;

    public void createAppointment(Appointments app)
    {
        appointmentRepo.save(app);
    }
    public List<Appointments> findall(){
        return appointmentRepo.findAll();
    }
}
