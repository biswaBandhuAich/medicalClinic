package com.example.medical.Repository;

import com.example.medical.Bean.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import javax.persistence.Id;

@Component
public interface DoctorRepo extends JpaRepository<Doctor,Id> {
    public Doctor findByName(String s);
}
