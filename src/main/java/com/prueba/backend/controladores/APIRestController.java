package com.prueba.backend.controladores;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.backend.entidades.Tareas;
import com.prueba.backend.servicios.ITareaService;

@RestController
@RequestMapping("/api")
public class APIRestController {
	@Autowired
	private ITareaService tareasService;

	@GetMapping("/tareas")
	public List<Tareas> index() {
		return tareasService.findAll();
	}

	@GetMapping("/tareas/{id}")
	public Tareas show(@PathVariable Long id) {
		return this.tareasService.findById(id);
	}

	@PostMapping("/tareas")
	@ResponseStatus(HttpStatus.CREATED)
	public Tareas create(@RequestBody Tareas tareas) {
		this.tareasService.save(tareas);
		return tareas;
	}

	@PutMapping("/tareas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tareas update(@RequestBody Tareas tareas, @PathVariable Long id) {
		Tareas currentTareas = this.tareasService.findById(id);
		currentTareas.setNombre(tareas.getNombre());
		currentTareas.setDescripcion(tareas.getDescripcion());
		currentTareas.setDuracion(tareas.getDuracion());
		this.tareasService.save(currentTareas);
		return currentTareas;
	}

	@DeleteMapping("/tareas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Tareas currentTareas = this.tareasService.findById(id);
		this.tareasService.delete(currentTareas);
	}
}
