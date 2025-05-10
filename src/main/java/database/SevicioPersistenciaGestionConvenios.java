package database;

import model.Conn;
import model.Convenio;
import model.GestorDeConvenios;

import java.io.InputStream;
import java.sql.*;

public class SevicioPersistenciaGestionConvenios implements GestorDeConvenios {
    @Override
    public void create(Convenio convenio) {
        PreparedStatement statement;
        Connection conn;
        try {
            conn = Conn.getConnection();

            statement = conn.prepareStatement(
                    "INSERT INTO convenio (id_entidad, id_proyecto, descripcion, fecha_inicio, fecha_fin) " +
                            "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, convenio.getIdEntidad());
            statement.setInt(2, convenio.getIdProyecto());
            statement.setString(3, convenio.getDescripcion());
            statement.setDate(4, Date.valueOf(convenio.getFechaInicio()));
            statement.setDate(5, Date.valueOf(convenio.getFechaFin()));

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                convenio.setId(idGenerado);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear un convenio", e);
        } finally {
            try {
                Conn.disconnect();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void upDateArchivo(Convenio convenio) {
        PreparedStatement statement;
        Connection conn;

        try {
            conn = Conn.getConnection();

            statement = conn.prepareStatement(
                    "UPDATE convenio SET archivo_pdf = ?, activo = ? WHERE id = ?");

            statement.setBytes(1, convenio.getArchivoPdf());
            statement.setBoolean(2, convenio.isActivo());
            statement.setInt(3, convenio.getId());

            int filas = statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                Conn.disconnect();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void cargarArchivoConvenio(int idConvenio, InputStream archivoPDF) {
        try (Connection conn = Conn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE convenios SET archivo_pdf = ?, activo = TRUE WHERE id = ?")) {

            stmt.setBlob(1, archivoPDF);
            stmt.setInt(2, idConvenio);

            int filas = stmt.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el archivo PDF del convenio.");
        }
    }
    }
