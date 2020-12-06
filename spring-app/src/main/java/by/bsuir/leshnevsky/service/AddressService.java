package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<Address> getAllAddress();
    void saveAddress(Address address);
    Address getAddressById(Integer id);
    void deleteAddressById(Integer id);
}
