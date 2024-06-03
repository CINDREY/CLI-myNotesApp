package com.example.myNotesApp;

import com.example.config.DatabaseConfig;
import com.example.model.Notes;
import com.example.service.NotesServiceImpl;
import com.example.service.Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapdb.DB;

import static org.junit.jupiter.api.Assertions.*;

public class NotesServiceImplTest {
    private DB db;
    private Service service;

    @BeforeEach
    public void setUp() {
        db = DatabaseConfig.getMemoryDatabase();
        service = new NotesServiceImpl(db);
    }

    @AfterEach
    public void tearDown() {
        db.close();
    }

    @Test
    public void testCreateTodo() {
        Notes notes = service.create("Test message");
        assertNotNull(notes);
        assertEquals("Test message", notes.getMessage());
    }

    @Test
    public void testGetAll() {
        service.create("Test message 1");
        service.create("Test message 2");
        assertEquals(2, service.getAll().size());
    }

    @Test
    public void testGetById() {
        Notes todo = service.create("Test message");
        Notes fetched = service.getById(todo.getId());
        assertNotNull(fetched);
        assertEquals(todo.getMessage(), fetched.getMessage());
    }

    @Test
    public void testUpdateTodo() {
        Notes notes = service.create("Test message");
        service.update(notes.getId(), "Updated message");
        Notes updated = service.getById(notes.getId());
        assertEquals("Updated message", updated.getMessage());
    }

    @Test
    public void testDeleteTodo() {
        Notes notes = service.create("Test message");
        service.delete(notes.getId());
        assertNull(service.getById(notes.getId()));
    }

}
