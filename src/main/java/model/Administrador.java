package model;

import java.time.LocalDate;


public class Administrador extends Usuario {

    private Convenios convenios;

    public Administrador(int id, String nombreUsuario, String contrasenia, String nombre, String email, GestorDeConvenios gestor) {
        super(id, nombreUsuario, contrasenia, nombre, email);
        this.convenios = new Convenios(gestor);

    }
    public Convenio generarConvenio(int idEntidad, int idProyecto, String descripcion,
                                    LocalDate fechaInicio, LocalDate fechaFin) {

        return this.convenios.nuevoConvenio(idEntidad, idProyecto, descripcion, fechaInicio, fechaFin);
    }


}