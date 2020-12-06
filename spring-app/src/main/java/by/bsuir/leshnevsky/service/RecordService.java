package by.bsuir.leshnevsky.service;

import by.bsuir.leshnevsky.models.Record;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {
    List<Record> getAllRecord();
    void saveRecord(Record record);
    Record getRecordById(Integer id);
    void deleteRecordById(Integer id);
}
