package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.Room;
import by.bsuir.leshnevsky.repository.RoomRepository;
import by.bsuir.leshnevsky.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    public Room getRoomById(Integer id) {
        Optional<Room> optional = roomRepository.findById(id);
        Room room = null;
        if(optional.isPresent()) {
            room = optional.get();
        }else {
            throw new RuntimeException("Кабинет не найден " + id);
        }
        return room;
    }

    @Override
    public void deleteRoomById(Integer id) {
        this.roomRepository.deleteById(id);
    }



}
