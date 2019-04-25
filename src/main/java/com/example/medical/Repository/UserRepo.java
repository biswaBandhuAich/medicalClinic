package com.example.medical.Repository;

import com.example.medical.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
public interface UserRepo extends JpaRepository<User, Id> {
    public User findByEmail(String email);
}
