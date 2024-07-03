package com.microservicio.recomendacionProfesores.Repository;

import com.microservicio.recomendacionProfesores.Document.Evaluacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EvaluacionRepository extends MongoRepository<Evaluacion, String> {

    List<Evaluacion> findAll();

    List<Evaluacion> findAllByIdProfesor(ObjectId idProfesor);

    List<Evaluacion> findAllByUsuarioEstudiante(String usuarioEstudiante);

    List<Evaluacion> findAllByEstrellas(int estrellas);

    <S extends Evaluacion> S save(S evaluacion);

    void deleteById(String id);
}
