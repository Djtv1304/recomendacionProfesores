package com.microservicio.recomendacionProfesores.Service;

import com.microservicio.recomendacionProfesores.Document.Evaluacion;
import com.microservicio.recomendacionProfesores.Repository.EvaluacionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionService {

    EvaluacionRepository evaluacionRepository;

    @Autowired
    public EvaluacionService(EvaluacionRepository evaluacionRepository) {

        this.evaluacionRepository = evaluacionRepository;

    }

    public List<Evaluacion> findAll() {

        return evaluacionRepository.findAll();

    }

    public List<Evaluacion> findAllByIdProfesor(ObjectId idProfesor) {

        return evaluacionRepository.findAllByIdProfesor(idProfesor);

    }

    public List<Evaluacion> findAllByUsuarioEstudiante(String usuarioEstudiante) {

        return evaluacionRepository.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    public List<Evaluacion> findAllByEstrellas(int estrellas) {

        return evaluacionRepository.findAllByEstrellas(estrellas);

    }

    public Evaluacion save(Evaluacion evaluacion) {

        return evaluacionRepository.save(evaluacion);

    }

    public void deleteById(String id) {

        evaluacionRepository.deleteById(id);

    }

}
