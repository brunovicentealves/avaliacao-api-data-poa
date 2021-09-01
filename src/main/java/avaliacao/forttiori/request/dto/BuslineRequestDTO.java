package avaliacao.forttiori.request.dto;

import avaliacao.forttiori.model.BusLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuslineRequestDTO {

	private String busLines;
	private String codeBusLine;

	public BuslineRequestDTO(BusLine dto) {

		this.busLines = dto.getBusLines();
		this.codeBusLine = dto.getCodeBusLine();

	}

}
