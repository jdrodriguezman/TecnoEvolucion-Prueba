package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.PersonaDaniela;
import com.example.demo.repository.person.impl.PersonaRepository;

@Service
public class PersonaServicesImpl implements PersonaService{
	
    @Autowired
    private PersonaRepository repository;

	@Override
	public Optional createService(PersonaDaniela persona) {
		 return Optional.of(repository.create(persona));
	}

	@Override
	public Optional getByIdService(Integer id) {
		Optional<PersonaDaniela> optional = repository.getById(id);
        if(optional.isPresent()){
            return optional;
        }else
            return Optional.empty();
	}


	@Override
	public Optional getAllService() {
		return Optional.of(repository.getAll());
	}


	@Override
	public Optional updateService(PersonaDaniela persona) {
		Optional<PersonaDaniela> optional = repository.getById(persona.getId());
        if(optional.isPresent()){
            return Optional.of(repository.update(persona));
        }else
            return Optional.empty();
	}


	@Override
	public void deleteService(Integer id) {
		repository.delete(id);
	}

}
