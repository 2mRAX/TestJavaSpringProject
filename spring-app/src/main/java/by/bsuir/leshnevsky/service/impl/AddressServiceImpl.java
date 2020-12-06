package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.Address;
import by.bsuir.leshnevsky.repository.AddressRepository;
import by.bsuir.leshnevsky.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public void saveAddress(Address address) {
        this.addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Integer id) {
        Optional<Address> optional = addressRepository.findById(id);
        Address address = null;
        if(optional.isPresent()) {
            address = optional.get();
        }else {
            throw new RuntimeException("Адрес не найден " + id);
        }
        return address;
    }

    @Override
    public void deleteAddressById(Integer id) {
        this.addressRepository.deleteById(id);
    }
}
