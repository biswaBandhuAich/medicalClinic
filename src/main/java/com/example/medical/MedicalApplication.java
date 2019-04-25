package com.example.medical;

import com.example.medical.Bean.Doctor;
import com.example.medical.Bean.User;
import com.example.medical.services.DocDml;
import com.example.medical.services.EmailService;
import com.example.medical.services.UserDml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalApplication implements CommandLineRunner {
    UserDml userDml;
    DocDml docDml;
    private EmailService mail;

    public static void main(String[] args) {
        SpringApplication.run(MedicalApplication.class, args);
    }

    @Autowired
    public void setDocDml(DocDml docDml) {
        this.docDml = docDml;
    }

    @Autowired
    public void setUserDml(UserDml userDml) {
        this.userDml = userDml;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Biswa Bandhu","Aich","biswan8@gmail.com","123");
        User user2 = new User("Minal Huda","Khan","minal.khan@tcs.com","123");
        userDml.createUser(user1);
        userDml.createUser(user2);

        Doctor doc1=new Doctor("Biswa","Md","Eye");
        Doctor doc2=new Doctor("Minal","Md","Eye");
        Doctor doc3=new Doctor("Anagha","Md","Eye");
        Doctor doc4=new Doctor("Bhawana","Md","Eye");
        docDml.createDoctor(doc1);
        docDml.createDoctor(doc2);
        docDml.createDoctor(doc3);
        docDml.createDoctor(doc4);
    }

    @Autowired
    public void setMail(EmailService mail) {
        this.mail = mail;
    }


}

