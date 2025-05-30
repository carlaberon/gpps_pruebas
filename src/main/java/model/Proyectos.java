package model;

public class Proyectos {
    private GestorDeProyectos gestorDeProyectos;

    public Proyectos(GestorDeProyectos gestorDeProyectos){
        this.gestorDeProyectos = gestorDeProyectos;
    }

    public void propuestaDeProyecto(
            int id, String nombre, String descripcion, Boolean estado, String areaDeInteres,
            Estudiante estudiante, Director director, Tutor docenteSupervisor
    ) {
        var proyecto = new Proyecto(id, nombre, descripcion, estado, areaDeInteres,estudiante, director, docenteSupervisor);
        this.gestorDeProyectos.registrarPropuestaDeProyecto(proyecto);
    }
}
