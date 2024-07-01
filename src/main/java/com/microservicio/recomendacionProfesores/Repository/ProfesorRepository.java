package com.microservicio.recomendacionProfesores.Repository;

import com.microservicio.recomendacionProfesores.Document.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepository extends MongoRepository<Profesor, String> {

    List<Profesor> findAll();

    List<Profesor> findAllByNombre(String nombre);

    Optional<Profesor> findById(String id);

    <S extends Profesor> S save(S profesor);

    void deleteById(String id);

    Profesor findByCorreo(String correo);

}
