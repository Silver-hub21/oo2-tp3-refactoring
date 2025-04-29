package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);

        //Utilizando try-catch:
        try {
            var personas = repo.buscarPorNombre("Vla");
            for (Persona persona : personas) {
                System.out.println("Encontrado: " + persona.nombre() + " " + persona.apellido());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        //Utilizando optional:
        var persona = repo.buscarId(1L);
        persona.ifPresent(p ->
                System.out.println("Encontrado: " + p.nombre() + " " + p.apellido())
        );
    }

}
