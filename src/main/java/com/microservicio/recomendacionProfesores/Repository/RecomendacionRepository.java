package com.microservicio.recomendacionProfesores.Repository;

import com.microservicio.recomendacionProfesores.Document.Recomendacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecomendacionRepository extends MongoRepository<Recomendacion, String> {

    List<Recomendacion> findAll();

    List<Recomendacion> findAllByIdProfesor(ObjectId idProfesor);

    List<Recomendacion> findAllByUsuarioEstudiante(String usuarioEstudiante);

    <S extends Recomendacion> S save(S recomendacion);

    void deleteById(String id);

}
