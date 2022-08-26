package com.piolo.tercero.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piolo.tercero.modelo.Tercero;
import com.piolo.tercero.repositorio.IRepositorio;

@Service
public class Servicios {

	@Autowired
	IRepositorio repositorio;
	
	public List<Tercero> listarTerceros(){
		return repositorio.findAll();
	}
	
	public void eliminarTercero(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void guardarTercero(Tercero tercero) {
		repositorio.save(tercero);
	}
	
	public Tercero obtenerTerceroPorId(Integer id){
		return repositorio.findById(id).get();
	}
	
	
}
