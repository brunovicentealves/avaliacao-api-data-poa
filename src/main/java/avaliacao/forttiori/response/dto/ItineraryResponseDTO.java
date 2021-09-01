package avaliacao.forttiori.response.dto;

import avaliacao.forttiori.model.Itinerary;
import avaliacao.forttiori.response.client.dto.RecordsItineraryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryResponseDTO {

	private Long id;

	private String line;

	private String sense;

	private String tableType;

	private String dayType;

	private String day;

	private String defectiveAdapter;

	public ItineraryResponseDTO(Itinerary dto) {
		this.id = dto.getId();
		this.line = dto.getLine();
		this.sense = dto.getSense();
		this.tableType = dto.getTableType();
		this.dayType = dto.getTableType();
		this.day = dto.getDay();
		this.defectiveAdapter = dto.getDefectiveAdapter();
	}

	public ItineraryResponseDTO(RecordsItineraryResponseDTO dto) {
		this.id = Long.valueOf(dto.get_id());
		this.line = dto.getLinha();
		this.sense = dto.getSentido();
		this.tableType = dto.getTipo_tabela();
		this.dayType = dto.getTipo_dia();
		this.day = dto.getHorario_largada();
		this.defectiveAdapter = dto.getAdaptado_deficiente();
	}
}
