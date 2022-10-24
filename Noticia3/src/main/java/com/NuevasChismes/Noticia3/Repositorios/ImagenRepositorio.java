/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NuevasChismes.Noticia3.Repositorios;

import com.NuevasChismes.Noticia3.Entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen,String>{

    public Optional<Imagen> findById(Long id);
    
}
