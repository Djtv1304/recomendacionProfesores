package com.microservicio.recomendacionProfesores.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Recomendaciones")
public class Recomendacion {

    @Id
    private ObjectId id;

    private ObjectId idProfesor;
    private String usuarioEstudiante;
    private String motivo;
    private String fecha;

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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

