package com.NuevasChismes.Noticia3.Servicios;

import com.NuevasChismes.Noticia3.Entidades.Imagen;
import com.NuevasChismes.Noticia3.Entidades.Noticia;
import com.NuevasChismes.Noticia3.Excepciones.MiException;

import com.NuevasChismes.Noticia3.Repositorios.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticiaServicio {
    
    @Autowired(required = true)
    private NoticiaRepositorio noticiaRepositorio;
    @Autowired(required = true)
    private ImagenServicio miserv;
    
    @Transactional
    public void crearNoticia(String titulo, String cuerpo, Long id, MultipartFile archivo) throws MiException, Exception {
        
        validar(titulo, cuerpo, archivo);
        
        //Optional<Noticia> respuesta = noticiaRepositorio.findById(id);
        
        Noticia noticia = new Noticia();
        
        noticia.setId(id);
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        
        Imagen imagen = miserv.guardar(archivo);
        noticia.setFoto(imagen);
        
        noticiaRepositorio.save(noticia);
        
    }
    
    @Transactional
    public void actualizarNoticia(String titulo, Long id, String cuerpo, MultipartFile archivo) throws Exception {
        
        validar(titulo, cuerpo, archivo);
        
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);
//        try {
//            Noticia miNoticia = new Noticia();
//
//            if (respuesta.isPresent()) {
//                miNoticia = respuesta.get();
//            }
//            miNoticia.setCuerpo(titulo);
//            Imagen miImagen = miserv.guardar(archivo);
//            miNoticia.setFoto(miImagen);
//            miNoticia.setCuerpo(cuerpo);
//            return noticiaRepositorio.save(miNoticia);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return null;

        if (respuesta.isPresent()) {
            
            Noticia noticia = respuesta.get();
            
            noticia.setTitulo(titulo);
            
            noticia.setCuerpo(cuerpo);
            
            String idImagen = null;
            
            if (noticia.getFoto() != null) {
                idImagen = noticia.getFoto().getId();
            }
            
            Imagen imagen = miserv.actualizar(archivo, idImagen);
            noticia.setFoto(imagen);
            
            noticiaRepositorio.save(noticia);
        }
        
    }
    
    @Transactional
    public List<Noticia> listarNoticias() {
        List<Noticia> miLista = new ArrayList();
        miLista = noticiaRepositorio.findAll();
        return miLista;
    }
    
    private void validar(String titulo, String cuerpo, MultipartFile archivo) throws MiException {
        if (titulo == null) {
            throw new MiException("El titulo no puede estar vacio");
        }
        if (cuerpo == null) {
            throw new MiException("El cuerpo no puede estar vacio");
        }
        if (archivo == null) {
            throw new MiException("El archivo no puede estar vacio");
        }
    }
    
    @Transactional
    public void eliminarNoticia(Long id) {
        noticiaRepositorio.deleteById(id);
        //Noticia noticia = noticiaRepositorio.eliminarNoticia(id);
        //return noticia;
        // ==.deleteneews();
    }
    
        @Transactional
    public Noticia getOne(Long id) {
        return noticiaRepositorio.getOne(id);
    }
    
}
