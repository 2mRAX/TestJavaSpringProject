package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.Patient;
import by.bsuir.leshnevsky.repository.PatientRepository;
import by.bsuir.leshnevsky.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatient(Patient patient) {
        this.patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        Patient patient = null;
        if(optional.isPresent()) {
            patient = optional.get();
        }else {
            throw new RuntimeException("Пациент не найден " + id);
        }
        return patient;
    }

    @Override
    public void deletePatientById(Integer id) {
        this.patientRepository.deleteById(id);
    }
}
