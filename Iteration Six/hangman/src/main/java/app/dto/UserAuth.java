package app.dto;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuth {
	
	@JsonbProperty
	private String id;
	@JsonbProperty
	private String username;
	@JsonbProperty
	private String password;
	@JsonbProperty
	private String email;
}
