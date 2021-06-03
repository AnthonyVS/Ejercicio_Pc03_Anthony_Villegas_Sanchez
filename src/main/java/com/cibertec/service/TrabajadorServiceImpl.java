package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Trabajador;
import com.cibertec.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository repository;

	@Override
	public List<Trabajador> listaTrabajador() {
		return repository.findAll();
	}

	@Override
	public Trabajador insertaActualizaTrabajador(Trabajador obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaTrabajador(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Trabajador> listaTrabajadorPorNombreLike(String filtro) {
		return repository.listaTrabajadorPorNombreLike(filtro);
	}

	@Override
	public Optional<Trabajador> obtienePorId(int idTrabajador) {
		return repository.findById(idTrabajador);
	}

	@Override
	public List<Trabajador> listaPorRuc(String ruc) {
		return repository.findByRuc(ruc);
	}

	@Override
	public List<Trabajador> listaPorRuc(String ruc, int idTrabajador) {
		return repository.findByRucAndIdTrabajadorNot(ruc, idTrabajador);
	}

	

}

