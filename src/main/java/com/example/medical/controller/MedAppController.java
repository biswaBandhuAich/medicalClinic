package com.example.medical.controller;

import com.example.medical.Bean.Appointments;
import com.example.medical.Bean.User;
import com.example.medical.services.AppointmentDml;
import com.example.medical.services.DocDml;
import com.example.medical.services.UserDml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MedAppController {
    UserDml userService;
    DocDml doctorService;
    AppointmentDml appointmentDml;

    @Autowired
    public void setDoctorService(DocDml doctorService) {
        this.doctorService = doctorService;
    }

    @Autowired
    public void setUserService(UserDml userService) {
        this.userService = userService;
    }
    @Autowired
    public void setAppointmentService(AppointmentDml appointmentDml){
        this.appointmentDml=appointmentDml;
    }
    @RequestMapping(value = "/firstPage")
    public String goToFirstPage() {
        return "user";
    }

    @RequestMapping(value = "/index")
    public String login(Model model) {
        return "index";
    }

    @RequestMapping(value = "/newReg", method = RequestMethod.GET)
    public String newReg(Model model) {
        System.out.println("In here");
        model.addAttribute("user", new User());
        return "newPatient";
    }

    @RequestMapping(path = "/AvailableDoctors")
    public String goToDoctorsPage(Model model) {
        model.addAttribute("doctors", doctorService.findAll());
        return "AvailableDoctors";
    }

    @RequestMapping(value = "/registration")
    public void newRegistration(User user) {
        userService.createUser(user);
        System.out.print("Succesfully Created");
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/appointment")
    public String getAppointment(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("user", userService.findUser(username));
        model.addAttribute("doctors", doctorService.findAll());
        return "BookAppointment";
    }

    @PostMapping(value = "/bookAppointment")
    public String scheduleAppointment(Model model,@RequestParam(name = "email") String name,
                                      @RequestParam("lastName") String lastName,
                                      @RequestParam("doctor") String doctor) {

        Appointments appointment=new Appointments(userService.findUser(name),
                doctorService.findDoctorByName(doctor));
        appointmentDml.createAppointment(appointment);
        System.out.println("Checking appointments"+appointment.getDoctor().getName()+appointment
        .getUser().getFirstName());
        return "welcome";
    }
    @RequestMapping(value = "/checkAllAppointments")
    public String checkAllAppointments(Model model) {

        if(appointmentDml.findall().isEmpty()){
            System.out.println("Khali ha andar");
        }
        for(Appointments app:appointmentDml.findall()){
            System.out.println("Here it is what you have ever wanred"+app.getDoctor().getName());
        }
        model.addAttribute("apointments",appointmentDml.findall());
        return "AllAppointments";
    }
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }

}