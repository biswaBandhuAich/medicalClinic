package com.example.medical.services;

import com.example.medical.Bean.User;
import com.example.medical.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDml {
    UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(User user){
        userRepo.save(user);
    }
    public User findUser(String username){return userRepo.findByEmail(username);}

    public boolean find(String email,Object password){
        System.out.println("Almost There" + email);
        User u=userRepo.findByEmail(email);
        System.out.println("From Db"+u.getPassword()+"  csdcs  "+password.toString());
        if(u!=null){
            if(u.getPassword().equals(password.toString())){
                return true;
            }
            else{
                System.out.println("Sorry I failed");
                return false;

            }
        }
        return false;
    }
}
