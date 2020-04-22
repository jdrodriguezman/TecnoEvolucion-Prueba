package com.example.demo.services;

import java.util.Optional;

import com.example.demo.model.PersonaDaniela;

public interface PersonaService {

    Optional createService(PersonaDaniela persona);

    Optional getByIdService(Integer id);

    Optional getAllService();

    Optional updateService(PersonaDaniela user);

    void deleteService(Integer id);

}
