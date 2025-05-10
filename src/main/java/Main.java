import database.SevicioPersistenciaGestionConvenios;
import model.Administrador;

public class Main {
    public static void main(String[] args) {

        SevicioPersistenciaGestionConvenios adminConvenios = new SevicioPersistenciaGestionConvenios();
        Administrador admin = new Administrador(1, "admin", "1234", "carla","alracnoreb@gmail.com", adminConvenios);
//        admin.generarConvenio(2, 3, "gestion de proyectos", LocalDate.now(), LocalDate.now().plus(Period.of(1, 2, 10)));
    }
}
