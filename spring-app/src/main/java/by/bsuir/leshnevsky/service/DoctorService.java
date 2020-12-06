package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {
    List<Doctor> getAllDoctor();
    void saveDoctor(Doctor doctor);
    Doctor getDoctorById(Integer id);
    void deleteDoctorById(Integer id);
}
