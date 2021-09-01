package avaliacao.forttiori.response.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordsItineraryResponseDTO {

	private String _id;
	private String data_extracao;
	private String linha;
	private String sentido;
	private String tipo_tabela;
	private String tipo_dia;
	private String horario_largada;
	private String adaptado_deficiente;

}
