package com.example.service;

import com.example.model.Notes;

import java.util.List;

public interface Service {

    List<Notes> getAll();

    Notes getById(long id);

    Notes create(String message);

    Notes update(long id, String message);

    void delete(long id);
}

