package avaliacao.forttiori.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItinerarySaveRequestDTO {

	private String line;

	private String sense;

	private String tableType;

	private String dayType;

	private String day;

	private String defectiveAdapter;

}
