package co.com.javeriana.entity;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="Usuarios")
public class Client implements Serializable {

		public static final long serialVersionUID = 4894729030347835498L;
		private String firstName;
		private String lastName;
		private String cc;
		private String cellNumber;
		 @ApiModelProperty(hidden = true) 
		@Id
		 @NonNull
		private String userName;
		private String cargo;
		private String pass;
		private String entidad;
		private String email;
		
	
}
