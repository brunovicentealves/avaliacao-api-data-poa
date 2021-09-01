package avaliacao.forttiori.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusScheduleRequestDTO {

	private String linha;

	private String sentido;

	private String tipoTabela;

	private String tipoDia;

	private String dia;

	private String adaptadoDeficiente;

}
