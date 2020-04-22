package com.example.demo.repository.person;

import org.springframework.stereotype.Repository;

import com.example.demo.model.PersonaDaniela;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface IPersonaRepository extends CrudRepository<PersonaDaniela, Integer> {

}
