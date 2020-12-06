package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> getAllPatient();
    void savePatient(Patient patient);
    Patient getPatientById(Integer id);
    void deletePatientById(Integer id);
}
