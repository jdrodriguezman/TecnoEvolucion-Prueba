package com.example.demo.repository.person.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.PersonaDaniela;
import com.example.demo.repository.person.IPersonaRepository;

import java.util.Optional;

@Component
public class PersonaRepositoryImpl implements PersonaRepository {

    @Autowired
    private IPersonaRepository repository;

    @Override
    public Optional<PersonaDaniela> create(PersonaDaniela persona) {
        return Optional.of(repository.save(persona));
    }

    @Override
    public Optional<PersonaDaniela> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Iterable<PersonaDaniela>> getAll() {
        return Optional.of(repository.findAll());
    }

    @Override
    public Optional<PersonaDaniela> update(PersonaDaniela persona) {
        return Optional.of(repository.save(persona));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
