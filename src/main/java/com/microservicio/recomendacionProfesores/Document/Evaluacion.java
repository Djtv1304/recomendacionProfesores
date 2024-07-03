package com.microservicio.recomendacionProfesores.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Evaluaciones")
public class Evaluacion {

    @Id
    private ObjectId id;

    private ObjectId idProfesor;
    private String usuarioEstudiante;
    private int estrellas;

    // Getters and Setters

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }

    public String getIdProfesor() {
        return idProfesor != null ? idProfesor.toHexString() : null;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor != null ? new ObjectId(idProfesor) : null;
    }

    public String getUsuarioEstudiante() {
        return usuarioEstudiante;
    }

    public void setUsuarioEstudiante(String usuarioEstudiante) {
        this.usuarioEstudiante = usuarioEstudiante;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

}

