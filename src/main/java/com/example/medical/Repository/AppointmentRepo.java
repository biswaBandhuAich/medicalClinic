package com.example.medical.Repository;

import com.example.medical.Bean.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
public interface AppointmentRepo extends JpaRepository<Appointments, Id> {
}
