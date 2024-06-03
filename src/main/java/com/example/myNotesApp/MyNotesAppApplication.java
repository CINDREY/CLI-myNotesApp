package com.example.myNotesApp;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.service.NotesServiceImpl;
import com.example.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.cli.CommandHandler;


@SpringBootApplication
public class MyNotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyNotesAppApplication.class, args);


	Service service = new NotesServiceImpl();

	// Crear nota
        service.create("Learn MapDB");

	// Obtener todas los notas
        System.out.println("All Notes: " + service.getAll());

	// Obtener notas por id
        System.out.println("Notes with ID 1: " + service.getById(1));

	// Actualizar notas
        service.update(1, "Learn MapDB with modifications");

	// Eliminar una nota
        service.delete(1);

	// Cerrar la base de datos
        ((NotesServiceImpl)service).close();


        CommandHandler commandHandler = new CommandHandler();
        commandHandler.start();


	}
}
