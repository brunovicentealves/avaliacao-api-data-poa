package avaliacao.forttiori.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import avaliacao.forttiori.request.dto.ItineraryRequestDTO;
import avaliacao.forttiori.response.client.dto.RecordsItineraryResponseDTO;
import avaliacao.forttiori.service.ItineraryService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/itinerary")
public class ItineraryBusController {

	@Autowired
	private ItineraryService service;

	@GetMapping
	@ApiOperation(value = "Retorna Informações itinerário  pelo nome do onibus ")
	public ResponseEntity<List<RecordsItineraryResponseDTO>> getItineraryBusByName(@RequestBody ItineraryRequestDTO dto) {

		return ResponseEntity.ok(service.getItineraryBus(dto));
	}

}
