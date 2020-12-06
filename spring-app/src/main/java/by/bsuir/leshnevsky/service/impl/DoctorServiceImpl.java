package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.Doctor;
import by.bsuir.leshnevsky.repository.DoctorRepository;
import by.bsuir.leshnevsky.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        this.doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        Doctor doctor = null;
        if(optional.isPresent()) {
            doctor = optional.get();
        }else {
            throw new RuntimeException("Доктор не найден " + id);
        }
        return doctor;
    }

    @Override
    public void deleteDoctorById(Integer id) {
        this.doctorRepository.deleteById(id);
    }
}
