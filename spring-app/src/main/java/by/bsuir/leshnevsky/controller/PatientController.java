package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.Patient;
import by.bsuir.leshnevsky.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping()
    public String viewPatientList(Model model) {
        model.addAttribute("patients", patientService.getAllPatient());
        return "patient/patient_info";
    }

    @GetMapping("/new")
    public String newPatient(@ModelAttribute("patient") Patient patient) {
        return "patient/patient_add";
    }

    @PostMapping("/new")
    public String createPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/patient_add";
        }
        patientService.savePatient(patient);
        return "redirect:/patient";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patient/patient_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "patient/patient_upd";

        patientService.savePatient(patient);
        return "redirect:/patient";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patient/patient_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        patientService.deletePatientById(id);
        return "redirect:/patient";
    }
}
