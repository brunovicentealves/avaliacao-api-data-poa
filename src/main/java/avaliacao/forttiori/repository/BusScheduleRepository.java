package avaliacao.forttiori.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import avaliacao.forttiori.model.BusSchedule;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {

}
