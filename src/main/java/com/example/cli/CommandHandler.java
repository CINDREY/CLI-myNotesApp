package com.example.cli;

import com.example.service.Service;
import com.example.service.NotesServiceImpl;
import java.util.Scanner;


public class CommandHandler {

    private final Service service;

    public CommandHandler() {
        this.service = new NotesServiceImpl();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to My Notes CLI App! Type 'help' to see available commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] commandParts = input.split(" ", 2);
            String command = commandParts[0];
            String argument = commandParts.length > 1 ? commandParts[1] : "";

            switch (command) {
                case "create":
                    if (argument.isEmpty()) {
                        System.out.println("Usage: create <note_message>");
                    } else {
                        service.create(argument);
                        System.out.println("Note created.");
                    }
                    break;
                case "getAll":
                    System.out.println("All Notes: " + service.getAll());
                    break;
                case "getById":
                    try {
                        long id = Long.parseLong(argument);
                        System.out.println("Note with ID " + id + ": " + service.getById(id));
                    } catch (NumberFormatException e) {
                        System.out.println("Usage: getById <note_id>");
                    }
                    break;
                case "update":
                    try {
                        String[] parts = argument.split(" ", 2);
                        long id = Long.parseLong(parts[0]);
                        String newMessage = parts[1];
                        service.update(id, newMessage);
                        System.out.println("Note updated.");
                    } catch (Exception e) {
                        System.out.println("Usage: update <note_id> <new_message>");
                    }
                    break;
                case "delete":
                    try {
                        long id = Long.parseLong(argument);
                        service.delete(id);
                        System.out.println("Note deleted.");
                    } catch (NumberFormatException e) {
                        System.out.println("Usage: delete <note_id>");
                    }
                    break;
                case "help":
                    printHelp();
                    break;
                case "exit":
                    ((NotesServiceImpl) service).close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command. Type 'help' for a list of available commands.");
                    break;
            }
        }
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  create <note_message>      - Create a new note with the specified message.");
        System.out.println("  getAll                     - Retrieve all notes.");
        System.out.println("  getById <note_id>          - Retrieve a note by its ID.");
        System.out.println("  update <note_id> <message> - Update the message of the note with the specified ID.");
        System.out.println("  delete <note_id>           - Delete the note with the specified ID.");
        System.out.println("  help                       - Display this help message.");
        System.out.println("  exit                       - Exit the application.");
    }
}

