package com.prueba.backend.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.backend.entidades.GccobranzasGestor;
import com.prueba.backend.servicios.ITareaService;

@RestController
@RequestMapping("/api")
public class APIRestController {
	@Autowired
	private ITareaService tareasService;

	@GetMapping("/localidades")
	public List<GccobranzasGestor> index() {
		return tareasService.findAll2();
	}

}
