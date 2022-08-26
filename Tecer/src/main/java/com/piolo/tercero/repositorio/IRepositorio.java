package com.piolo.tercero.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.piolo.tercero.modelo.Tercero;

public interface IRepositorio extends JpaRepository<Tercero, Integer> {

}
