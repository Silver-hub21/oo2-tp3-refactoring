package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonaRepository {

    private Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {

        this.jdbi = jdbi;
    }

    /**
     * Busca por nombre a parte
     */
    public List<Persona> buscarPorNombre(String nombreOParte) {
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where nombre like ?")
                    .bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();

            var personas = new ArrayList<Persona>();

            validarResultado(rs.isEmpty(), "No se encontró la persona con nombre: " + nombreOParte);

            for (Map<String, String> map : rs) {
                personas.add(mapearPersonaDesde(map));
            }

            return personas;
        });

    }

    /**
     * Dado un id, retorna:
     * - null si el id no se encuentra en la BD
     * - la instancia de Persona encontrada
     */
    public Optional<Persona> buscarId(Long id) {
        return jdbi.withHandle(handle ->
                handle.select("SELECT nombre, apellido FROM persona WHERE id_persona = ?")
                        .bind(0, id)
                        .mapToMap(String.class)
                        .stream()                     // Stream<Map<String,String>>
                        .findFirst()                  // Optional<Map<String,String>>
                        .map(this::mapearPersonaDesde) // Optional<Persona>
        );
    }

    private static void validarResultado(boolean rs, String nombreOParte) {
        if (rs) {
            throw new RuntimeException(nombreOParte);
        }
    }

    private Persona mapearPersonaDesde(Map<String, String> map) {
        return new Persona(map.get("nombre"), map.get("apellido"));
    }

}


