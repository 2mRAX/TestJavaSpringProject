package by.bsuir.leshnevsky.repository;

import by.bsuir.leshnevsky.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
}
