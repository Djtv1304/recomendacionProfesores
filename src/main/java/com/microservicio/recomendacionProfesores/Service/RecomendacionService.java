package com.microservicio.recomendacionProfesores.Service;

import com.microservicio.recomendacionProfesores.Document.Recomendacion;
import com.microservicio.recomendacionProfesores.Repository.RecomendacionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacionService {

    RecomendacionRepository recomendacionRepository;

    @Autowired
    public RecomendacionService(RecomendacionRepository recomendacionRepository) {

        this.recomendacionRepository = recomendacionRepository;

    }

    public List<Recomendacion> findAll() {

        return recomendacionRepository.findAll();

    }

    public List<Recomendacion> findAllByIdProfesor(ObjectId idProfesor) {

        return recomendacionRepository.findAllByIdProfesor(idProfesor);

    }

    public List<Recomendacion> findAllByUsuarioEstudiante(String usuarioEstudiante) {

        return recomendacionRepository.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    public Recomendacion save(Recomendacion recomendacion) {

        return recomendacionRepository.save(recomendacion);

    }

    public void deleteById(String id) {

        recomendacionRepository.deleteById(id);

    }


}
