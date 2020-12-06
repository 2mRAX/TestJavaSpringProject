package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.District;
import by.bsuir.leshnevsky.repository.DistrictRepository;
import by.bsuir.leshnevsky.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAllDistrict() {
        return districtRepository.findAll();
    }

    @Override
    public void saveDistrict(District district) {
        this.districtRepository.save(district);
    }

    @Override
    public District getDistrictById(Integer id) {
        Optional<District> optional = districtRepository.findById(id);
        District district = null;
        if(optional.isPresent()) {
            district = optional.get();
        }else {
            throw new RuntimeException("Участок не найден " + id);
        }
        return district;
    }

    @Override
    public void deleteDistrictById(Integer id) {
        this.districtRepository.deleteById(id);
    }
}
