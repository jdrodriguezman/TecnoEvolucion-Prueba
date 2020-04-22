package com.example.demo.controller;

import com.example.demo.model.PersonaDaniela;

import org.springframework.http.ResponseEntity;

public interface IPersonaApi {
   ResponseEntity createPersona(PersonaDaniela persona);

   ResponseEntity getUserById(Integer id);

   ResponseEntity getAllPersona();

   ResponseEntity updatePersona(Integer id, PersonaDaniela persona);

   ResponseEntity deletePersona(Integer id);
}
