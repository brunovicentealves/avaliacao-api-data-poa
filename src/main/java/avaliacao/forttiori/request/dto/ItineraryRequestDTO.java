package avaliacao.forttiori.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryRequestDTO {

	private String entryType;
	private int limit;
	private int offiset;

}
