package ir.haytech.programgenerator.repositories;

import ir.haytech.programgenerator.entities.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
    Date findTopByOrderByIdDesc();
}
