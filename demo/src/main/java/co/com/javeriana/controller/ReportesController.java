package co.com.javeriana.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/reporte")
public class ReportesController {

	@GetMapping(path = "/{id}/patrones",produces = MediaType.APPLICATION_PDF_VALUE)
	
	public  @ResponseBody byte[] consultarReporte(@PathVariable(name = "id", required = true) String wallet_id)throws IOException {
		String base64 = "";
	    byte[] bytes = Base64.decodeBase64(base64);
	    InputStream in = getClass()
	    	      .getResourceAsStream("/co/com/javeriana/produceimage/REPORTE.pdf");
	    return IOUtils.toByteArray(in);
	
		
	}
}
