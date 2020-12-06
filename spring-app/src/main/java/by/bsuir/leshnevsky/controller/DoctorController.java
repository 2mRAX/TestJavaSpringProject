package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.Doctor;
import by.bsuir.leshnevsky.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping()
    public String viewPatientList(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctor());
        return "doctor/doctor_info";
    }

    @GetMapping("/new")
    public String newDoctor(@ModelAttribute("doctor") Doctor doctor) {
        return "doctor/doctor_add";
    }

    @PostMapping("/new")
    public String createDoctor(@ModelAttribute("doctor") @Valid Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "doctor/doctor_add";
        }
        doctorService.saveDoctor(doctor);
        return "redirect:/doctor";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "doctor/doctor_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("doctor") @Valid Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "doctor/doctor_upd";

        doctorService.saveDoctor(doctor);
        return "redirect:/doctor";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "doctor/doctor_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctor";
    }
}
