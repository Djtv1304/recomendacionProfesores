package com.microservicio.recomendacionProfesores.Service;

import com.microservicio.recomendacionProfesores.Document.Profesor;
import com.microservicio.recomendacionProfesores.Repository.ProfesorRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    ProfesorRepository  profesorRepository;

    MongoTemplate mongoTemplate;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository, MongoTemplate mongoTemplate) {

        this.profesorRepository = profesorRepository;
        this.mongoTemplate = mongoTemplate;

    }

    public List<Profesor> findAll() {

        return profesorRepository.findAll();

    }

    public List<Profesor> findAllByNombre(String nombre) {

        return profesorRepository.findAllByNombre(nombre);

    }

    public Profesor findById(String id) {

        return profesorRepository.findById(id).orElse(null);

    }

    public Profesor save(Profesor profesor) {

        // Comprobar si ya existe un profesor con el mismo correo
        Profesor existingProfesor = profesorRepository.findByCorreo(profesor.getCorreo());
        if (existingProfesor != null) {
            // Lanzar una excepción o devolver un error
            throw new RuntimeException("Ya existe un profesor con el correo: " + profesor.getCorreo());
        }

        return profesorRepository.save(profesor);

    }

    public void deleteById(String id) {

        profesorRepository.deleteById(id);

    }

    public Profesor updateEstado(String id, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Profesor.class);
    }

    public Profesor updateEstadoByCorreo(String correo, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("correo").is(correo));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Profesor.class);
    }

}
