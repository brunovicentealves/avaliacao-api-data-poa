package avaliacao.forttiori.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import avaliacao.forttiori.exception.BusNotfoundException;
import avaliacao.forttiori.model.BusLine;
import avaliacao.forttiori.repository.BusLineRepository;
import avaliacao.forttiori.response.dto.BusLineDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusLineService {

	@Autowired
	private BusLineRepository repository;

	public List<BusLineDTO> findAllBusLinePaged() {
		log.info("Buscando todas as linhas de onibus");
		List<BusLine> list = repository.findAll();

		return list.stream().map(x -> new BusLineDTO(x)).collect(Collectors.toList());
	}

	public BusLineDTO findByCodeBusLine(String codeBusLine) {

		BusLine busLine = repository.findBycodeBusLine(codeBusLine);

		if (busLine == null) {
			throw new BusNotfoundException("Não eocntrou linha de Onibus");
		}
		return new BusLineDTO(busLine);
	}

}
