package avaliacao.forttiori.response.client.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBusScheduleReponseDTO {

	private String include_total;

	private String resource_id;

	private List<FieldsBusScheduleResponseDTO> fields;

	private String record_format;

	private List<RecordsBusScheduleResponseDTO> records;

	private String limit;

}
