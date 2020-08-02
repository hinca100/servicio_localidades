package com.prueba.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.backend.entidades.Tareas;

public interface ItareasDao extends CrudRepository<Tareas, Long> {

}
