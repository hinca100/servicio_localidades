package com.prueba.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.backend.dao.ItareasDao;
import com.prueba.backend.entidades.Tareas;


@Service
public class TareasServiceImpl implements ITareaService{

	@Autowired
	private ItareasDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tareas> findAll() {
		return (List<Tareas>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tareas cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Tareas findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Tareas cliente) {
		clienteDao.delete(cliente);
		
	}

}
