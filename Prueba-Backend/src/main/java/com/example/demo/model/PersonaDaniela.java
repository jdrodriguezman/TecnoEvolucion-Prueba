package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PersonaDaniela implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	int cedula;
	String nombre;
	Date fecha_nacimiento;
}
