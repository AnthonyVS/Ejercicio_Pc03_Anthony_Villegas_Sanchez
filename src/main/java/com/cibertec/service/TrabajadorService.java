package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Trabajador;

public interface TrabajadorService {

	public abstract List<Trabajador> listaTrabajador();
	public abstract Trabajador insertaActualizaTrabajador(Trabajador obj);
	public abstract Optional<Trabajador> obtienePorId(int idTrabajador);
	public abstract void eliminaTrabajador(int id);
	public abstract List<Trabajador> listaTrabajadorPorNombreLike(String filtro);
	public abstract List<Trabajador> listaPorRuc(String ruc);
	public abstract List<Trabajador> listaPorRuc(String ruc, int idTrabajador);
	
}
