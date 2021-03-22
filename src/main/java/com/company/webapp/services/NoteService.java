package com.company.webapp.services;

import com.company.webapp.dto.Note;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteService {

    List<Note> getAll();

    void add(String name, String description, LocalDateTime time);

    void delete(Integer id);
    Note get(Integer id);
}
