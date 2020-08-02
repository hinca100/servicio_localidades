package com.prueba.backend.servicios;

import java.util.List;

import com.prueba.backend.entidades.Tareas;

public interface ITareaService {
	public List<Tareas> findAll();

	public void save(Tareas tareas);

	public Tareas findById(Long id);

	public void delete(Tareas tareas);
}
