package com.example.demo.repository.person.impl;

import java.util.Optional;

import com.example.demo.model.PersonaDaniela;

public interface PersonaRepository {

    Optional<PersonaDaniela> create(PersonaDaniela persona);

    Optional<PersonaDaniela> getById(Integer id);

    Optional<Iterable<PersonaDaniela>> getAll();

    Optional<PersonaDaniela> update(PersonaDaniela persona);

    void delete(Integer id);

}
