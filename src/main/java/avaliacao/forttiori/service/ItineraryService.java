package avaliacao.forttiori.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import avaliacao.forttiori.client.DataPoaClient;
import avaliacao.forttiori.exception.BusBadRequestException;
import avaliacao.forttiori.model.Itinerary;
import avaliacao.forttiori.repository.ItineraryRepository;
import avaliacao.forttiori.request.dto.ItineraryRequestDTO;
import avaliacao.forttiori.request.dto.ItinerarySaveRequestDTO;
import avaliacao.forttiori.response.client.dto.RecordsItineraryResponseDTO;
import avaliacao.forttiori.response.dto.ItineraryResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItineraryService {

	@Autowired
	private DataPoaClient client;

	@Autowired
	private ItineraryRepository repository;

	@Transactional
	public void saveItinerary(RecordsItineraryResponseDTO dto) {
		log.info("Salvando no banco o itinerario e verificando se ja existe o cadastro");
		Itinerary itinerary = new Itinerary(dto);

		log.info("Buscando o itinerario por id ");
		Optional<Itinerary> itineraryFindById = findItineraryById(Long.valueOf(dto.get_id()));

		log.info("Verificando se encontrou algo na tabela do banco");
		if (!itineraryFindById.isPresent()) {
			log.info("Salvando o itinerario na tabela do banco");
			repository.save(itinerary);
		}

	}

	public List<ItineraryResponseDTO> getItineraryBus(ItineraryRequestDTO dto) {

		log.info("Realizando uma Consulta de itinerarios da Api datapoa ");
		List<RecordsItineraryResponseDTO> dataRecords = client.getItineraryDataPoa(dto.getEntryType(), dto.getLimit(), dto.getOffiset());

		log.info("Realizando salvamento no banco de dados  dos dados buscado da APi datapoa ");
		SavingBusItineraryList(dataRecords);

		return dataRecords.stream().map(x -> new ItineraryResponseDTO(x)).collect(Collectors.toList());
	}

	private void SavingBusItineraryList(List<RecordsItineraryResponseDTO> dataRecords) {
		for (RecordsItineraryResponseDTO records : dataRecords) {
			saveItinerary(records);

		}
	}

	@Transactional(readOnly = true)
	public Optional<Itinerary> findItineraryById(Long id) {

		log.info("Verificando se existe Itinerario pelo id:{}" + id);
		Optional<Itinerary> itinerary = repository.findById(id);

		return itinerary;
	}

	public ItineraryResponseDTO saveItiterary(ItinerarySaveRequestDTO itinerarySaveRequestDTO) {
		Itinerary itinerary = new Itinerary();

		copyDtoToEntity(itinerarySaveRequestDTO, itinerary);

		Itinerary entity = checkItinerary(itinerary.getLine());
		if (entity == null) {
			itinerary = repository.save(itinerary);
		} else {

			throw new BusBadRequestException("Ja existe um itinerario cadastrado com esse parametros");
		}

		return new ItineraryResponseDTO(itinerary);
	}

	@Transactional(readOnly = true)
	public Itinerary checkItinerary(String line) {
		log.info("Buscando o itinerario do onibus pela linha {}" + line);
		Itinerary itinerary = repository.findByline(line);

		return itinerary;
	}

	private void copyDtoToEntity(ItinerarySaveRequestDTO dto, Itinerary entity) {

		entity.setLine(dto.getLine());
		entity.setSense(dto.getSense());
		entity.setTableType(dto.getTableType());
		entity.setDefectiveAdapter(dto.getDefectiveAdapter());
		entity.setDayType(dto.getDayType());
		entity.setDay(dto.getDay());

	}

}
