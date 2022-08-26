package com.piolo.tercero.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.piolo.tercero.modelo.Tercero;
import com.piolo.tercero.servicios.Servicios;

@RestController
public class Controlador {

	@Autowired
	Servicios servicios;
	
	@GetMapping("/Listar")
	public List<Tercero> listaTodos(){
		return servicios.listarTerceros();
	}
	
	@GetMapping("/ListarPorId/{id}")
	public ResponseEntity<Tercero> obtenerTerceroPorId(@PathVariable Integer id){
		try {
			Tercero tercero = servicios.obtenerTerceroPorId(id);
			return new ResponseEntity<Tercero>(tercero, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<Tercero>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/EliminarPorId/{id}")
	public void eliminaPorId(@PathVariable Integer id) {
		servicios.eliminarTercero(id);
	}
	
	@PostMapping("/GuardarTercero")
	public void guardarTercero(@RequestBody Tercero tercero) {
		servicios.guardarTercero(tercero);
	}
	
	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<?> actualizarTercero(@RequestBody Tercero tercero, @PathVariable Integer id){
		try {
			Tercero terceroExistente = servicios.obtenerTerceroPorId(id);
			servicios.guardarTercero(tercero);
			return new ResponseEntity<Tercero>(HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<Tercero>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
