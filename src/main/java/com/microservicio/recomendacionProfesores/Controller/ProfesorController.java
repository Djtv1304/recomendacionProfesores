package com.microservicio.recomendacionProfesores.Controller;

import com.microservicio.recomendacionProfesores.Document.Profesor;
import com.microservicio.recomendacionProfesores.Service.ProfesorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorController {

    ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {

        this.profesorService = profesorService;

    }

    @GetMapping("/docentesRecomendados/all")
    public List<Profesor> getAllDocentes() {

        return profesorService.findAll();

    }

    @PostMapping("/docentesRecomendados")
    public Profesor saveDocente(@RequestBody Profesor profesorNuevo) {

        if ( profesorNuevo.getId() == null || profesorNuevo.getId().isEmpty() ) {
            profesorNuevo.setId(new ObjectId().toHexString());
        }

        return profesorService.save(profesorNuevo);

    }

    @DeleteMapping("/docentesRecomendados/deleteById/{profesorId}")
    public String deleteDocenteById(@PathVariable String profesorId) {

        profesorService.deleteById(profesorId);

        return "Verificar si se ha eliminado correctamente el profesor por ID";

    }

    @PutMapping("/docentesRecomendados/updateEstadoById/{idProfesor}/{estadoNuevo}")
    public Profesor updateEstadoDocenteById(@PathVariable String idProfesor, @PathVariable String estadoNuevo) {

        return profesorService.updateEstado(idProfesor, estadoNuevo);

    }

    @PutMapping("/docentesRecomendados/updateEstadoByCorreo")
    public Profesor updateEstadoDocenteByCorreo(@RequestBody String correoProfesor, @RequestBody String estadoNuevo) {

        return profesorService.updateEstadoByCorreo(correoProfesor, estadoNuevo);

    }

}
