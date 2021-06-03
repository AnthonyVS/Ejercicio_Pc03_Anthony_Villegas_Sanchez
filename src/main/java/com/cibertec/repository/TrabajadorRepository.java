package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {

	
	@Query("Select a from Trabajador a where nombre like :fil")
	public abstract List<Trabajador> listaTrabajadorPorNombreLike(@Param("fil") String filtro);

	public abstract List<Trabajador> findByRuc(String ruc);
	public abstract List<Trabajador> findByRucAndIdTrabajadorNot(String ruc, int idTrabajador);
}

