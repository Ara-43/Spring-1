
package com.NuevasChismes.Noticia3.Repositorios;

import com.NuevasChismes.Noticia3.Entidades.Noticia;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long>{
    
//      @Query("DELETE u FROM Noticia u WHERE u.id = :id")
//    public Noticia eliminarNoticia(@Param("id")Long id);
}
