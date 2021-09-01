package avaliacao.forttiori.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import avaliacao.forttiori.response.client.dto.RecordsBusScheduleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_horario_onibus")
public class BusSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "txt_linha")
	private String line;

	@Column(name = "txt_sentido")
	private String sense;

	@Column(name = "txt_tipo")
	private String type;

	@Column(name = "txt_nome")
	private String name;

	@Column(name = "txt_endereco_logradouro")
	private String enderecoLogradouro;

	public BusSchedule(RecordsBusScheduleResponseDTO dto) {

		this.line = dto.getLinha();
		this.sense = dto.getSentido();
		this.type = dto.getTipo();
		this.name = dto.getNome();
		this.enderecoLogradouro = dto.getEndereco_logradouro();
	}

}
