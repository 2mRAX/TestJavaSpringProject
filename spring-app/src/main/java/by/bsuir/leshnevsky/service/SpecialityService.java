package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.Speciality;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecialityService {
    List<Speciality> getAllSpec();
    void saveSpec(Speciality speciality);
    Speciality getSpecById(Integer id);
    void deleteSpecById(Integer id);

}
