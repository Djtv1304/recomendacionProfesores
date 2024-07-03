package com.microservicio.recomendacionProfesores.Service;

import com.microservicio.recomendacionProfesores.Document.LikeDislike;
import com.microservicio.recomendacionProfesores.Repository.LikeDislikeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeDislikeService {

    LikeDislikeRepository likeDislikeRepository;

    @Autowired
    public LikeDislikeService(LikeDislikeRepository likeDislikeRepository) {

        this.likeDislikeRepository = likeDislikeRepository;

    }

    public List<LikeDislike> findallByidProfesor(ObjectId idProfesor) {

        return likeDislikeRepository.findAllByIdProfesor(idProfesor);

    }

    public List<LikeDislike> findallByUsuarioEstudiante(String usuarioEstudiante) {

        return likeDislikeRepository.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    public LikeDislike save(LikeDislike likeDislike) {

        return likeDislikeRepository.save(likeDislike);

    }

    public void deleteById(String id) {

        likeDislikeRepository.deleteById(id);

    }

}
