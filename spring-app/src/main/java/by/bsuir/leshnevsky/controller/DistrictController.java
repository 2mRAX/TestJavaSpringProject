package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.District;
import by.bsuir.leshnevsky.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/district")
public class DistrictController {
    private final DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }


    @GetMapping()
    public String viewDistrictList(Model model) {
        model.addAttribute("districts", districtService.getAllDistrict());
        return "district/district_info";
    }

    @GetMapping("/new")
    public String newDistrict(@ModelAttribute("district") District district) {
        return "district/district_add";
    }

    @PostMapping("/new")
    public String createDistrict(@ModelAttribute("district") @Valid District district, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "district/district_add";
        }
        districtService.saveDistrict(district);
        return "redirect:/district";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("district", districtService.getDistrictById(id));
        return "district/district_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("district") @Valid District district, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "district/district_upd";

        districtService.saveDistrict(district);
        return "redirect:/district";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("district", districtService.getDistrictById(id));
        return "district/district_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        districtService.deleteDistrictById(id);
        return "redirect:/district";
    }
}
