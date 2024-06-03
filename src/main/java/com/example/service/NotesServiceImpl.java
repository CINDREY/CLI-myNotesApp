package com.example.service;

import com.example.config.DatabaseConfig;
import com.example.model.Notes;
import com.example.util.IdGenerator;
import org.mapdb.DB;
import org.mapdb.Serializer;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class NotesServiceImpl implements Service{

    private DB db;
    private ConcurrentMap<Long, Notes> map;
    private IdGenerator idGenerator;


    public NotesServiceImpl(DB db) {
        this.db = db;
    }


    public NotesServiceImpl() {
        try {
            db = DatabaseConfig.getDatabase();
            map = db.hashMap("todo", Serializer.LONG, Serializer.JAVA).createOrOpen();
            idGenerator = new IdGenerator(map.keySet());
        } catch (Exception e) {
            System.err.println("Error al abrir la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Notes> getAll() {
        return map.values().stream().collect(Collectors.toList());
    }

    @Override
    public Notes getById(long id) {
        return map.get(id);
    }

    @Override
    public Notes create(String message) {
        Notes notes = new Notes(message);
        notes.setId(idGenerator.incrementAndGet());
        map.put(notes.getId(), notes);
        db.commit();
        return notes;
    }

    @Override
    public Notes update(long id, String message) {
        Notes notes = map.get(id);
        if (notes != null) {
            notes.setMessage(message);
            map.put(id, notes);
            db.commit();
        }
        return notes;
    }

    @Override
    public void delete(long id) {
        map.remove(id);
        db.commit();
    }

    public void close() {
        db.close();
    }



}
