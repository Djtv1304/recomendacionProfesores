package com.microservicio.recomendacionProfesores.Controller;

import com.microservicio.recomendacionProfesores.Document.Evaluacion;
import com.microservicio.recomendacionProfesores.Service.EvaluacionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluacionController {

    EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(EvaluacionService evaluacionService) {

        this.evaluacionService = evaluacionService;

    }

    @GetMapping("/evaluaciones/all")
    public List<Evaluacion> getAllEvaluaciones() {

        return evaluacionService.findAll();

    }

    @GetMapping("/evaluaciones/evaluacionesByProfesor/{idProfesor}")
    public List<Evaluacion> getEvaluacionesByProfesor(@PathVariable String idProfesor) {

        return evaluacionService.findAllByIdProfesor(new ObjectId(idProfesor));

    }

    @GetMapping("/evaluaciones/evaluacionesByEstudiante/{usuarioEstudiante}")
    public List<Evaluacion> getEvaluacionesByEstudiante(@PathVariable String usuarioEstudiante) {

        return evaluacionService.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    @GetMapping("/evaluaciones/evaluacionesByEstrellas/{estrellas}")
    public List<Evaluacion> getEvaluacionesByEstrellas(@PathVariable int estrellas) {

        return evaluacionService.findAllByEstrellas(estrellas);

    }

    @PostMapping("/evaluaciones")
    public Evaluacion saveEvaluacion(Evaluacion evaluacionNueva) {

        if ( evaluacionNueva.getId() == null || evaluacionNueva.getId().isEmpty() ) {
            evaluacionNueva.setId(new ObjectId().toHexString());
        }

        return evaluacionService.save(evaluacionNueva);

    }

    @DeleteMapping("/evaluaciones/deleteById/{evaluacionId}")
    public String deleteEvaluacionById(@PathVariable String evaluacionId) {

        evaluacionService.deleteById(evaluacionId);

        return "Verificar si se ha eliminado correctamente la evaluacion por ID";

    }

}
