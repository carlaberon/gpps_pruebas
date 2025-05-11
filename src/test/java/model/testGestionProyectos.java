package model;

import database.ServicioDePersistenciaGestionProyectos;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testGestionProyectos {
    @Test
    public void ProponerProyectoTest(){
        //setup
//        var gestorDeProyectoPersistencia = new ServicioDePersistenciaGestionProyectos();
        var gestorDeProyectoPersistenciaFake = new ServicioDePersistenciaGestionProyectosFake();
        var proyectos = new Proyectos(gestorDeProyectoPersistenciaFake);
        String nombreProyecto = "gpps";
        String descripcion = "desarrollar plataforma para la gestión de prácticas profesionales supervisadas en la UNRN";
        boolean estado = false; //el proyecto no se encuentra aprobado
        String areaDeInteres = "prácticas pre-profesionales";
        String nombreUsuarioEstudiante =  "CarlaBeron";
        String nombreEstudiante = "carla";
        String contraseniaEstudiante = "1234";
        String emailEstudiante = "alracnoreb@gmail.com";
        String legajoEstudiante = "UNRN-18143";
        boolean regular = true;
        String dirPostal = "8500";
        var estudiante = new Estudiante(nombreUsuarioEstudiante,contraseniaEstudiante, nombreEstudiante, emailEstudiante, legajoEstudiante, regular, dirPostal);
        var director = new Director(1,"director", "1234", "gabriel", "gabriel@gmail.com");
        var tutor = new Tutor(1, "tutor", "1234","hernan", "hernan@gmail.com", "interno");

        //ejercitacion
        proyectos.propuestaDeProyecto(1, nombreProyecto, descripcion, estado,areaDeInteres, estudiante, director,tutor);

        //verificacion
        assertEquals(nombreProyecto, gestorDeProyectoPersistenciaFake.project().getNombre());
        assertEquals(descripcion, gestorDeProyectoPersistenciaFake.project().getDescripcion());
        assertEquals(estado, gestorDeProyectoPersistenciaFake.project().getEstado());
        assertEquals(areaDeInteres, gestorDeProyectoPersistenciaFake.project().getAreaDeInteres());
        assertEquals(nombreEstudiante, gestorDeProyectoPersistenciaFake.project().getEstudiante().getNombre());
        assertEquals(nombreUsuarioEstudiante, gestorDeProyectoPersistenciaFake.project().getEstudiante().getNombreUsuario());
        assertEquals(emailEstudiante, gestorDeProyectoPersistenciaFake.project().getEstudiante().getEmail());
        assertEquals(legajoEstudiante, gestorDeProyectoPersistenciaFake.project().getEstudiante().getLegajo());
        assertEquals(legajoEstudiante, gestorDeProyectoPersistenciaFake.project().getEstudiante().getLegajo());

        //asert con los datos del director y del tutor

    }
}
