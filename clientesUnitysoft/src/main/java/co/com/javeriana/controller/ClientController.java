package co.com.javeriana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.com.javeriana.entity.Client;
import co.com.javeriana.model.ResponseModel;
import co.com.javeriana.service.SaveClients;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/client/v1")
@Api(tags = "Client Controller")
public class ClientController {
	@Autowired
	SaveClients clientServices;
	
	@PostMapping(value = "/{userName}/client")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "guardo exitosamente",response= ResponseModel.class),
	@ApiResponse(code = 412, message = "el usuario ya existe",response= ResponseModel.class),
	@ApiResponse(code = 500, message = "error en el servicio",response= ResponseModel.class)})
	@ResponseBody
	public ResponseEntity<Object> creditAccount(@PathVariable(name = "userName", required = true) String userName,
			@RequestBody Client input){
			input.setUserName(userName);
			clientServices.save(input);
		return new ResponseEntity<>("Se guardo correctamente",HttpStatus.OK);
	
	}
	@GetMapping(value = "/{userName}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "consulta exitosa",response= Client.class),
	@ApiResponse(code = 412, message = "el usuario ya existe",response= ResponseModel.class),
	@ApiResponse(code = 500, message = "error en el servicio",response= ResponseModel.class)})
	@ResponseBody
	public ResponseEntity<Object> getUser(@PathVariable(name = "userName", required = true) String userName){
						
		return new ResponseEntity<>(clientServices.findbyId(userName),HttpStatus.OK);
	
	}
	@GetMapping(value = "/allusers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "consulta exitosa"),
	@ApiResponse(code = 500, message = "error en el servicio",response= ResponseModel.class)})
	@ResponseBody
	public ResponseEntity<Object> getAllUser(){
						
		return new ResponseEntity<>(clientServices.findAll(),HttpStatus.OK);
	
	}
	@PatchMapping(value = "update/{userName}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "consulta exitosa"),
	@ApiResponse(code = 500, message = "error en el servicio",response= ResponseModel.class)})
	@ResponseBody
	public ResponseEntity<Object> updateUser(@PathVariable(name = "userName", required = true) String userName,
			@RequestBody Client input){
		input.setUserName(userName);
		clientServices.update(input);	
		return new ResponseEntity<>("se acualizo correctamente",HttpStatus.OK);
	
	}
	@DeleteMapping(value = "delete/{userName}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "consulta exitosa"),
	@ApiResponse(code = 500, message = "error en el servicio",response= ResponseModel.class)})
	@ResponseBody
	public ResponseEntity<Object> deleteUser(@PathVariable(name = "userName", required = true) String userName){
		
		clientServices.delete(userName);	
		return new ResponseEntity<>("se borro correctamente",HttpStatus.OK);
	
	}
}
