package by.bsuir.leshnevsky.controller;

import by.bsuir.leshnevsky.models.Room;
import by.bsuir.leshnevsky.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping()
    public String viewSpecList(Model model) {
        model.addAttribute("rooms", roomService.getAllRoom());
        return "room/room_info";
    }

    @GetMapping("/new")
    public String newRoom(@ModelAttribute("room") Room room) {
        return "room/room_add";
    }

    @PostMapping("/new")
    public String createRoom(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "room/room_add";
        }
        roomService.saveRoom(room);
        return "redirect:/room";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("room", roomService.getRoomById(id));
        return "room/room_upd";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "room/room_upd";

        roomService.saveRoom(room);
        return "redirect:/room";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") int id) {
        model.addAttribute("room", roomService.getRoomById(id));
        return "room/room_delete";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        roomService.deleteRoomById(id);
        return "redirect:/room";
    }

}
