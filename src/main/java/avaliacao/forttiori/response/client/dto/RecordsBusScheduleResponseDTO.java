package avaliacao.forttiori.response.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordsBusScheduleResponseDTO {

	private String _id;
	private String data_extracao;
	private String linha;
	private String sentido;
	private String nunero_sequencia;
	private String tipo;
	private String nome;
	private String endereco_logradouro;

}
