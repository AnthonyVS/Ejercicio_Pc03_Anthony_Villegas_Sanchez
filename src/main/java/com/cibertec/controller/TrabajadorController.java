package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Trabajador;
import com.cibertec.service.TrabajadorService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/trabajador")
public class TrabajadorController {
	

	@Autowired
	private TrabajadorService service;

	@GetMapping
	public ResponseEntity<List<Trabajador>> lista(){
		log.info(">>> lista ");
		return ResponseEntity.ok(service.listaTrabajador());
	}
	
	@PostMapping
	public ResponseEntity<Trabajador> registra(@RequestBody Trabajador obj){
		log.info(">>> registra " + obj.getIdTrabajador());
		return ResponseEntity.ok(service.insertaActualizaTrabajador(obj));
	}
	
	@PutMapping
	public ResponseEntity<Trabajador> actualiza(@RequestBody Trabajador obj){
		log.info(">>> actualiza " + obj.getIdTrabajador());
		Optional<Trabajador> optTrabajador =   service.obtienePorId(obj.getIdTrabajador());
		if (optTrabajador.isPresent()) {
			return ResponseEntity.ok(service.insertaActualizaTrabajador(obj));	
		}else {
			log.error(">>> actualiza " + obj.getIdTrabajador() + " no encontrado");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Trabajador> elimina(@PathVariable("id") int idTrabajador){
		log.info(">>> elimina " + idTrabajador);
		Optional<Trabajador> optTrabajador =   service.obtienePorId(idTrabajador);
		if (optTrabajador.isPresent()) {
			service.eliminaTrabajador(idTrabajador);
			return ResponseEntity.ok(optTrabajador.get());
		}else {
			log.error(">>> elimina " + idTrabajador + " no encontrado");
			return ResponseEntity.notFound().build();
		}
	}
	
}



