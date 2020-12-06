package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.Record;
import by.bsuir.leshnevsky.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    @GetMapping()
    public String viewRecordList(Model model) {
        model.addAttribute("records", recordService.getAllRecord());
        return "record/record_info";
    }

    @GetMapping("/new")
    public String newRecord(@ModelAttribute("record") Record record) {
        return "record/record_add";
    }

    @PostMapping("/new")
    public String createRecord(@ModelAttribute("record") @Valid Record record, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "record/record_add";
        }
        recordService.saveRecord(record);
        return "redirect:/record";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("record", recordService.getRecordById(id));
        return "record/record_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("record") @Valid Record record, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "record/record_upd";

        recordService.saveRecord(record);
        return "redirect:/record";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("record", recordService.getRecordById(id));
        return "record/record_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        recordService.deleteRecordById(id);
        return "redirect:/record";
    }

}
