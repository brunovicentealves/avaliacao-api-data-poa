package avaliacao.forttiori.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import avaliacao.forttiori.response.client.dto.RecordsItineraryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_itinerario")
public class Itinerary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "txt_linha")
	private String line;

	@Column(name = "txt_sentido")
	private String sense;

	@Column(name = "txt_tipo_tabela")
	private String tableType;

	@Column(name = "txt_tipo_dia")
	private String dayType;

	@Column(name = "txt_dia")
	private String day;

	@Column(name = "txt_adaptador_deficiente")
	private String defectiveAdapter;

	public Itinerary(RecordsItineraryResponseDTO dto) {
		this.id = Long.parseLong(dto.get_id());
		this.line = dto.getLinha();
		this.sense = dto.getSentido();
		this.tableType = dto.getTipo_tabela();
		this.dayType = dto.getTipo_dia();
		this.day = dto.getTipo_dia();
		this.defectiveAdapter = dto.getAdaptado_deficiente();
	}

}
