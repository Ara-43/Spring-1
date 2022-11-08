
package com.NuevasChismes.Noticia3.Controladores;

import com.NuevasChismes.Noticia3.Entidades.Noticia;
import com.NuevasChismes.Noticia3.Entidades.Usuario;
import com.NuevasChismes.Noticia3.Servicios.NoticiaServicio;
import com.NuevasChismes.Noticia3.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    NoticiaServicio noticiaServicio;
    
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario (@PathVariable String id){
        Usuario usuario = usuarioServicio.getOne(id);
        
       byte[] imagen= usuario.getImagen().getContenido();
       
       HttpHeaders headers = new HttpHeaders();
       
       headers.setContentType(MediaType.IMAGE_JPEG);
       
       return new ResponseEntity<>(imagen,headers, HttpStatus.OK); 
    }
    
     @GetMapping("/noticia/{id}")
    public ResponseEntity<byte[]> imagenNoticia (@PathVariable Long id){
        Noticia not = noticiaServicio.getOne(id);
        
       byte[] imagen= not.getFoto().getContenido();
       
       HttpHeaders headers = new HttpHeaders();
       
       headers.setContentType(MediaType.IMAGE_JPEG);
       
       return new ResponseEntity<>(imagen,headers, HttpStatus.OK); 
    }
}
