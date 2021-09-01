package avaliacao.forttiori.response.dto;

import avaliacao.forttiori.model.BusLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusLineDTO {

	private Long id;
	private String busLines;
	private String codeBusLine;

	public BusLineDTO(BusLine dto) {
		this.id = dto.getId();
		this.busLines = dto.getBusLines();
		this.codeBusLine = dto.getCodeBusLine();

	}

}
