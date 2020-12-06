package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.Speciality;
import by.bsuir.leshnevsky.repository.SpecialityRepository;
import by.bsuir.leshnevsky.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public List<Speciality> getAllSpec() {
        return specialityRepository.findAll();
    }

    @Override
    public void saveSpec(Speciality speciality) {
        this.specialityRepository.save(speciality);
    }

    @Override
    public Speciality getSpecById(Integer id) {
        Optional<Speciality> optional = specialityRepository.findById(id);
        Speciality speciality = null;
        if(optional.isPresent()) {
            speciality = optional.get();
        }else {
            throw new RuntimeException("Специальность не найдена " + id);
        }
        return speciality;
    }

    @Override
    public void deleteSpecById(Integer id) {
        this.specialityRepository.deleteById(id);
    }



}
