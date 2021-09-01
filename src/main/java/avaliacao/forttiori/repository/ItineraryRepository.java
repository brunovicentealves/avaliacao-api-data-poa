package avaliacao.forttiori.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import avaliacao.forttiori.model.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	Itinerary findByline(String line);

}
