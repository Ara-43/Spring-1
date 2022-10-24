
package com.NuevasChismes.Noticia3.Repositorios;

import com.NuevasChismes.Noticia3.Entidades.Noticia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoticiaRepositorio extends JpaRepository<Noticia,String>{

    public Optional<Noticia> findById(Long id);
    
 
}
