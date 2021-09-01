package avaliacao.forttiori.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import avaliacao.forttiori.model.BusLine;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Long> {

	BusLine findBycodeBusLine(String codeBusLine);

	@Query("SELECT b FROM BusLine b")
	Page<BusLine> findBusLine(Pageable pageRequest);

}
