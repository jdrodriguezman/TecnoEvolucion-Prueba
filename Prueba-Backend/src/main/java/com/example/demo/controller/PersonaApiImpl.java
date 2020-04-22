package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.commons.constans.api.user.EndpointPersonaApi;
import com.example.demo.commons.domains.response.builder.ResponseBuilder;
import com.example.demo.model.PersonaDaniela;
import com.example.demo.services.PersonaService;

@RestController
@RequestMapping(value = EndpointPersonaApi.PERSONA_API)
public class PersonaApiImpl implements IPersonaApi{

	@Autowired
    private PersonaService personService;	
	

	@Override
    @PostMapping(EndpointPersonaApi.CREATE_PERSONA)
	public ResponseEntity createPersona( @RequestBody PersonaDaniela persona) {
		return ResponseBuilder.newBuilder()
                .withStatus(HttpStatus.CREATED)
                .withResponse(personService.createService(persona))
                .buildResponse();
	}

	@Override
    @GetMapping(EndpointPersonaApi.GET_BY_ID_PERSONA)
	public ResponseEntity getUserById(@PathVariable("id") Integer id) {
		Optional<PersonaDaniela> opt = personService.getByIdService(id);
        return ResponseBuilder.newBuilder()
                .withStatus(opt.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .withResponse(opt.isPresent() ? opt.get() : null)
                .withMessage(opt.isPresent() ? null : "User not has been found")
                .buildResponse();
	}

	@Override
    @GetMapping(EndpointPersonaApi.GET_ALL_PERSONAS)
	public ResponseEntity getAllPersona() {
		return ResponseBuilder.newBuilder()
                .withStatus(HttpStatus.OK)
                .withResponse(personService.getAllService())
                .buildResponse();
	}

	@Override
	@PutMapping(EndpointPersonaApi.UPDATE_PERSONA)
	public ResponseEntity updatePersona(@PathVariable("id") Integer id, @RequestBody PersonaDaniela persona) {
		persona.setId(id);
        Optional opt = personService.updateService(persona);
        return ResponseBuilder.newBuilder()
                .withStatus(opt.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .withResponse(opt.isPresent() ? personService.updateService(persona) : null)
                .withMessage(opt.isPresent() ? null : "User not has been found")
                .buildResponse();
	}

	@Override
	@DeleteMapping(EndpointPersonaApi.DELETE_PERSONA)
	public ResponseEntity deletePersona(@PathVariable("id") Integer id) {
		personService.deleteService(id);
        return ResponseBuilder.newBuilder()
                .withStatus(HttpStatus.OK)
                .withMessage("User has been deleted")
                .buildResponse();
	}

}
