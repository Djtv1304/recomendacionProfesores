package com.microservicio.recomendacionProfesores.Repository;

import com.microservicio.recomendacionProfesores.Document.LikeDislike;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LikeDislikeRepository extends MongoRepository<LikeDislike, String> {

    List<LikeDislike> findAllByIdProfesor(ObjectId idProfesor);

    List<LikeDislike> findAllByUsuarioEstudiante(String usuarioEstudiante);

    <S extends LikeDislike> S save(S likeDislike);

    void deleteById(String id);
}
