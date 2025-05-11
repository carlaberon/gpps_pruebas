import database.ServicioDePersistenciaGestionProyectos;
import model.*;

public class PruebaUsoGestionProyectos {
    public static void main(String[] args) {
        //prueba HU: proponer proyecto

        var gestorDeProyectoPersistencia = new ServicioDePersistenciaGestionProyectos();
        var proyectos = new Proyectos(gestorDeProyectoPersistencia);
        String nombreProyecto = "gpps";
        String descripcion = "desarrollar plataforma para la gestión de prácticas profesionales supervisadas en la UNRN";
        boolean estado = false; //el proyecto no se encuentra aprobado
        String areaDeInteres = "prácticas pre-profesionales";
        var estudiante = new Estudiante("carla","contra1", "alrac", "alracnoreb@gmail.com", "UNRN-14183", true, "8500");
        var director = new Director(1,"director", "1234", "gabriel", "gabriel@gmail.com");
        var tutor = new Tutor(1, "tutor", "1234","hernan", "hernan@gmail.com", "interno");

        proyectos.propuestaDeProyecto(1, nombreProyecto, descripcion, estado,areaDeInteres, estudiante, director,tutor);
        //falta implementar la persistencia
    }
}
