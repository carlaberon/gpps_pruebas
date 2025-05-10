package model;

import java.time.LocalDate;

public class Convenios {
    private GestorDeConvenios gestionDeConvenios;

    public Convenios(GestorDeConvenios gestionDeConvenios) {
        this.gestionDeConvenios = gestionDeConvenios;
    }

    public Convenio nuevoConvenio(int idEntidad, int idProyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        var convenio = new Convenio(idEntidad,idProyecto,descripcion,fechaInicio,fechaFin);
        gestionDeConvenios.create(convenio);
        return convenio;
    }

    public void cargarConvenioFirmado(Convenio convenio, byte[] archivoPdf){
        convenio.setArchivoPdf(archivoPdf);
        convenio.activar();
        this.gestionDeConvenios.upDateArchivo(convenio);

    }
}