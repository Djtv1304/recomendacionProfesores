package com.microservicio.recomendacionProfesores.Controller;


import com.microservicio.recomendacionProfesores.Document.LikeDislike;
import com.microservicio.recomendacionProfesores.Service.LikeDislikeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomendacionProfesores")
public class LikeDislikeController {

    LikeDislikeService likeDislikeService;

    @Autowired
    public LikeDislikeController(LikeDislikeService likeDislikeService) {

        this.likeDislikeService = likeDislikeService;

    }

    @GetMapping("/likesDislikes/allByIdProfesor/{idProfesor}")
    public List<LikeDislike> getAllLikesDislikesByIdProfesor(@PathVariable String idProfesor) {

        return likeDislikeService.findallByidProfesor(new ObjectId(idProfesor));

    }

    @GetMapping("/likesDislikes/allByUsuarioEstudiante/{usuarioEstudiante}")
    public List<LikeDislike> getAllLikesDislikesByUsuarioEstudiante(@PathVariable String usuarioEstudiante) {

        return likeDislikeService.findallByUsuarioEstudiante(usuarioEstudiante);

    }

    @PostMapping("/likesDislikes")
    public LikeDislike saveLikeDislike(@RequestBody LikeDislike likeDislike) {

        if ( likeDislike.getId() == null || likeDislike.getId().isEmpty() ) {
            likeDislike.setId(new ObjectId().toHexString());
        }

        return likeDislikeService.save(likeDislike);

    }

    @DeleteMapping("/likesDislikes/deleteById/{likeDislikeId}")
    public String deleteLikeDislikeById(@PathVariable String likeDislikeId) {

        likeDislikeService.deleteById(likeDislikeId);

        return "Verificar si se ha eliminado correctamente el like/dislike por ID";

    }

}
