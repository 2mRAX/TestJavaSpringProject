package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.Address;
import by.bsuir.leshnevsky.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping()
    public String viewAddressList(Model model) {
        model.addAttribute("addresses", addressService.getAllAddress());
        return "address/address_info";
    }

    @GetMapping("/new")
    public String newAddress(@ModelAttribute("address") Address address) {
        return "address/address_add";
    }

    @PostMapping("/new")
    public String createAddress(@ModelAttribute("address") @Valid Address address, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "address/address_add";
        }
        addressService.saveAddress(address);
        return "redirect:/address";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("address", addressService.getAddressById(id));
        return "address/address_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("address") @Valid Address address, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "address/address_upd";

        addressService.saveAddress(address);
        return "redirect:/address";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("address", addressService.getAddressById(id));
        return "address/address_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        addressService.deleteAddressById(id);
        return "redirect:/address";
    }
}
