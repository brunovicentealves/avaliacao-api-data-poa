package avaliacao.forttiori.response.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataBusScheduleReponseDTO {

	private String help;
	private String success;
	private ResultBusScheduleReponseDTO result;

}
