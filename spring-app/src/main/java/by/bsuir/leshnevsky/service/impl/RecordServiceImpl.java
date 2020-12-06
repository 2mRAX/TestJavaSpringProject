package by.bsuir.leshnevsky.service.impl;

import by.bsuir.leshnevsky.models.Record;
import by.bsuir.leshnevsky.repository.RecordRepository;
import by.bsuir.leshnevsky.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<Record> getAllRecord() {
        return recordRepository.findAll();
    }

    @Override
    public void saveRecord(Record record) {
        this.recordRepository.save(record);
    }

    @Override
    public Record getRecordById(Integer id) {
        Optional<Record> optional = recordRepository.findById(id);
        Record record = null;
        if(optional.isPresent()) {
            record = optional.get();
        }else {
            throw new RuntimeException("Запись не найдена " + id);
        }
        return record;
    }

    @Override
    public void deleteRecordById(Integer id) {
        this.recordRepository.deleteById(id);
    }
}
