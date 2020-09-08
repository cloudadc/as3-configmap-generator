package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.*;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

//@RestController
//@RequestMapping(produces = {"application/json", "application/xml"})
//@Tag(name = "CIS Helper", description = "F5 CIS Helper API")
public class CISHelperGeneratorController {
	
	@RequestMapping(path = {"/version"}, method = {RequestMethod.GET})
	@Operation(summary = "Get version", description = "Return version")
	public EntityGeneratorVersion version() {
		
		EntityGeneratorVersion version = new EntityGeneratorVersion(VERSION);
		version.setAs3Version(AS3_VERSION);
		version.setCisVersion(CIS_VERSION);
		
		return version;
	}
	
	@RequestMapping(path = {"/sample"}, method = {RequestMethod.GET})
	@Operation(summary = "Sample", description = "An methods used to API doc develoment")
	public EntitySample sample(
			@Parameter(description = "ID", required = true) int id,
			@Parameter(description = "Name", required = true) String name,
			@Parameter(description = "Notes", required = true, allowEmptyValue = true) String notes,
			@Parameter(description = "Value", required = true, allowEmptyValue = true) int value,
			@Parameter(description = "Path", required = true) String path,
			@Parameter(description = "Allow", required = false) boolean allow) {
		return new EntitySample(id, name, notes, value, path, allow);
	}
	
	@RequestMapping(path = {"/load"}, method = {RequestMethod.GET})
	@Operation(summary = "load", description = "Return template")
	public String loadyaml() throws IOException {
		return load("http.tml");
	}

}
