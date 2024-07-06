package com.microservicio.recomendacionProfesores.Controller;

import com.microservicio.recomendacionProfesores.Document.Recomendacion;
import com.microservicio.recomendacionProfesores.Service.RecomendacionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomendacionProfesores")
public class RecomendacionController {

    RecomendacionService recomendacionService;

    @Autowired
    public RecomendacionController(RecomendacionService recomendacionService) {

        this.recomendacionService = recomendacionService;

    }

    @GetMapping("/recomendaciones/all")
    public List<Recomendacion> getAllRecomendaciones() {

        return recomendacionService.findAll();

    }

    @GetMapping("/recomendaciones/allByIdProfesor/{idProfesor}")
    public List<Recomendacion> getAllRecomendacionesByIdProfesor(@PathVariable String idProfesor) {

        ObjectId objectIdFromString = new ObjectId(idProfesor);

        return recomendacionService.findAllByIdProfesor(objectIdFromString);

    }

    @GetMapping("/recomendaciones/allByUsuarioEstudiante/{usuarioEstudiante}")
    public List<Recomendacion> getAllRecomendacionesByUsuarioEstudiante(@PathVariable String usuarioEstudiante) {

        return recomendacionService.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    @PostMapping("/recomendaciones")
    public Recomendacion saveRecomendacion(@RequestBody Recomendacion recomendacionNueva) {

        if ( recomendacionNueva.getId() == null || recomendacionNueva.getId().isEmpty() ) {
            recomendacionNueva.setId(new ObjectId().toHexString());
        }

        return recomendacionService.save(recomendacionNueva);

    }

    @DeleteMapping("/recomendaciones/deleteById/{recomendacionId}")
    public String deleteRecomendacionById(@PathVariable String recomendacionId) {

        recomendacionService.deleteById(recomendacionId);

        return "Verificar si se ha eliminado correctamente la recomendación por ID";

    }

}
