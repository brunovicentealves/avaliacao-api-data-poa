package avaliacao.forttiori.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import avaliacao.forttiori.request.dto.ItineraryRequestDTO;
import avaliacao.forttiori.request.dto.ItinerarySaveRequestDTO;
import avaliacao.forttiori.response.dto.ItineraryResponseDTO;
import avaliacao.forttiori.service.ItineraryService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/itinerary")
public class ItineraryBusController {

	@Autowired
	private ItineraryService service;

	@GetMapping
	@ApiOperation(value = "Retorna Informações itinerário  pelo nome do onibus ")
	public ResponseEntity<List<ItineraryResponseDTO>> getItineraryBusByName(@RequestBody ItineraryRequestDTO dto) {

		return ResponseEntity.ok(service.getItineraryBus(dto));
	}

	@PostMapping
	@ApiOperation(value = "Realiza o salvamento da linha de onibus")
	public ResponseEntity<ItineraryResponseDTO> saveProduct(@RequestBody ItinerarySaveRequestDTO itinerarySaveRequestDTO) {
		ItineraryResponseDTO itineraryResponseDTO = service.saveItiterary(itinerarySaveRequestDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itineraryResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(itineraryResponseDTO);
	}

}
