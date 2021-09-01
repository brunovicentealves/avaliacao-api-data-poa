package avaliacao.forttiori.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import avaliacao.forttiori.exception.BusBadRequestException;
import avaliacao.forttiori.exception.BusNotfoundException;
import avaliacao.forttiori.model.BusLine;
import avaliacao.forttiori.repository.BusLineRepository;
import avaliacao.forttiori.request.dto.BuslineRequestDTO;
import avaliacao.forttiori.response.dto.BusLineDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusLineService {

	@Autowired
	private BusLineRepository repository;

	public List<BusLineDTO> findAllBusLinePaged() {
		log.info("Buscando todas as linhas de onibus.");
		List<BusLine> list = repository.findAll();

		return list.stream().map(x -> new BusLineDTO(x)).collect(Collectors.toList());
	}

	public BusLineDTO findByCodeBusLine(String codeBusLine) {
		log.info("Buscando as linha de onibus pela codigo da linha ");
		BusLine busLine = repository.findBycodeBusLine(codeBusLine);

		if (busLine == null) {
			throw new BusNotfoundException("Não encontrou linha de Onibus.");
		}
		return new BusLineDTO(busLine);
	}

	public BusLineDTO saveBusLine(BuslineRequestDTO dto) {
		log.info("Salvando a linha de onibus nova. ");
		BusLine entity = new BusLine();
		copyDtoToEntity(dto, entity);
		log.info("Checkando se existe cadastro da linha{} no banco de dados" + dto.getCodeBusLine());
		BusLine busline = checkBusLine(entity.getCodeBusLine());

		if (busline == null) {
			entity = repository.save(entity);
		} else {

			throw new BusBadRequestException("Ja existe um onibus cadastrado com esse parametros");
		}
		return new BusLineDTO(entity);
	}

	@Transactional(readOnly = true)
	public BusLine checkBusLine(String codeBusline) {
		log.info("Buscando a linha de onibsu pelo codigo{}" + codeBusline);
		BusLine busLine = repository.findBycodeBusLine(codeBusline);

		return busLine;
	}

	private void copyDtoToEntity(BuslineRequestDTO dto, BusLine entity) {

		entity.setBusLines(dto.getBusLines());
		entity.setCodeBusLine(dto.getCodeBusLine());

	}

}
