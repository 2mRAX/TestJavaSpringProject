package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    List<District> getAllDistrict();
    void saveDistrict(District doctor);
    District getDistrictById(Integer id);
    void deleteDistrictById(Integer id);
}
