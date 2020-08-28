package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.load;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(produces = {"application/json", "application/xml", "text/plain"})
@Tag(name = "CIS Ingress", description = "F5 CIS Ingress Sample")
public class CISIngressGeneratorController {
	
	@RequestMapping(path = {"/generate/ingress/sample"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS Ingress Sample", description = "Returns F5 CIS Ingress Sample")
	public String generateConfigmap() throws IOException {

		
		return load( "ingress.tml");
	}

}
