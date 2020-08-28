package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(produces = {"application/json", "application/xml"})
@Tag(name = "Helper", description = "F5 CIS Helper API")
public class CISHelperGeneratorController {
	
	@RequestMapping(path = {"/version"}, method = {RequestMethod.GET})
	@Operation(summary = "Get version", description = "Return version")
	public GeneratorVersion version() {
		
		GeneratorVersion version = new GeneratorVersion(VERSION);
		version.setAs3Version(AS3_VERSION);
		version.setCisVersion(CIS_VERSION);
		
		return version;
	}
	
	@RequestMapping(path = {"/sample"}, method = {RequestMethod.GET})
	@Operation(summary = "Sample", description = "An methods used to API doc develoment")
	public Sample sample(
			@Parameter(description = "ID", required = true) int id,
			@Parameter(description = "Name", required = true) String name,
			@Parameter(description = "Notes", required = true, allowEmptyValue = true) String notes,
			@Parameter(description = "Value", required = true, allowEmptyValue = true) int value,
			@Parameter(description = "Path", required = true) String path,
			@Parameter(description = "Allow", required = false) boolean allow) {
		return new Sample(id, name, notes, value, path, allow);
	}

}
