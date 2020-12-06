package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.Speciality;
import by.bsuir.leshnevsky.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/speciality")
public class SpecialityController {
    private final SpecialityService specialityService;

    @Autowired
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @GetMapping()
    public String viewSpecList(Model model) {
        model.addAttribute("specialities", specialityService.getAllSpec());
        return "speciality/speciality_info";
    }

    @GetMapping("/new")
    public String newSpec(@ModelAttribute("speciality") Speciality speciality) {
        return "speciality/speciality_add";
    }

    @PostMapping("/new")
    public String createSpec(@ModelAttribute("speciality") @Valid Speciality speciality, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "speciality/speciality_add";
        }
        specialityService.saveSpec(speciality);
        return "redirect:/speciality";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("speciality", specialityService.getSpecById(id));
        return "speciality/speciality_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("speciality") @Valid Speciality speciality, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "speciality/speciality_upd";

        specialityService.saveSpec(speciality);
        return "redirect:/speciality";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("speciality", specialityService.getSpecById(id));
        return "speciality/speciality_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        specialityService.deleteSpecById(id);
        return "redirect:/speciality";
    }

}
