package avaliacao.forttiori.client;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import avaliacao.forttiori.exception.BusBadRequestException;
import avaliacao.forttiori.response.client.dto.DataBusScheduleReponseDTO;
import avaliacao.forttiori.response.client.dto.DataItineraryReponseDTO;
import avaliacao.forttiori.response.client.dto.RecordsBusScheduleResponseDTO;
import avaliacao.forttiori.response.client.dto.RecordsItineraryResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataPoaClient {

	public List<RecordsItineraryResponseDTO> getItineraryDataPoa(String entryType, int limit, int offiset) {

		try {
			log.info("Buscando os Itinerarios dos onibus de porto alegre pela api dataPoa");
			RestTemplate template = new RestTemplate();

			UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("dadosabertos.poa.br").path("api/3/action/datastore_search")
							.queryParam("resource_id", "cb96a73e-e18b-4371-95c5-2cf20e359e6c").queryParam("offset", offiset)
							.queryParam("limit", limit).queryParam("q", entryType).build();

			ResponseEntity<DataItineraryReponseDTO> entity = template.getForEntity(uri.toUriString(), DataItineraryReponseDTO.class);

			DataItineraryReponseDTO dataItinerary = entity.getBody();

			return dataItinerary.getResult().getRecords();

		} catch (Exception e) {

			throw new BusBadRequestException("Houve algum problema na APi dataPoa");

		}
	}

	public List<RecordsBusScheduleResponseDTO> getBusScheduleDataPoa(String entryType, int limit, int offiset) {

		try {

			log.info("Buscando  tabela de horários dos onibus de porto alegre pela api dataPoa");
			RestTemplate template = new RestTemplate();

			UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("dadosabertos.poa.br").path("api/3/action/datastore_search")
							.queryParam("resource_id", "c8cf58cf-649c-49b1-af78-d0e0beeb6332").queryParam("offset", offiset)
							.queryParam("limit", limit).queryParam("q", entryType).build();

			ResponseEntity<DataBusScheduleReponseDTO> entity = template.getForEntity(uri.toUriString(), DataBusScheduleReponseDTO.class);

			DataBusScheduleReponseDTO dataBusSchedule = entity.getBody();

			return dataBusSchedule.getResult().getRecords();

		} catch (Exception e) {

			throw new BusBadRequestException("Houve algum problema na APi dataPoa");

		}

	}

}
