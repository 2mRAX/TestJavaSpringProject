package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    List<Room> getAllRoom();
    void saveRoom(Room room);
    Room getRoomById(Integer id);
    void deleteRoomById(Integer id);
}
