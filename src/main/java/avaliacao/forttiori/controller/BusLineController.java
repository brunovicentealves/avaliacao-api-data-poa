package avaliacao.forttiori.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import avaliacao.forttiori.request.dto.BuslineRequestDTO;
import avaliacao.forttiori.response.dto.BusLineDTO;
import avaliacao.forttiori.service.BusLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/busline")
@Api(value = " Linha de Onibus")
public class BusLineController {

	@Autowired
	private BusLineService service;

	@GetMapping
	@ApiOperation(value = "Retorna todas as linhas de onibus ")
	public ResponseEntity<List<BusLineDTO>> findAll() {

		return ResponseEntity.ok(service.findAllBusLinePaged());

	}

	@GetMapping("/{codeBusLine}")
	@ApiOperation(value = "Realiza uma busca da linha de onibus pela codigo da linha de onibus ")
	public ResponseEntity<BusLineDTO> findByBusName(@PathVariable String codeBusLine) {

		return ResponseEntity.ok(service.findByCodeBusLine(codeBusLine));
	}

	@PostMapping
	@ApiOperation(value = "Realiza o salvamento da linha de onibus")
	public ResponseEntity<BusLineDTO> saveProduct(@RequestBody BuslineRequestDTO busLineRequestDTO) {
		BusLineDTO busLineDTO = service.saveBusLine(busLineRequestDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(busLineDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(busLineDTO);
	}

}
