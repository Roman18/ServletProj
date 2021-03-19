package com.company.webapp.services;

import com.company.webapp.db.JdbcTemplate;
import com.company.webapp.dto.Note;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class DbNoteService implements NoteService{
    private final JdbcTemplate template;
    public DbNoteService(JdbcTemplate template){
        this.template = template;

    }

    @Override
    public List<Note> getAll() {
        try {
            return template.query(
                    "SELECT id, name, description, time FROM notes",
                    (ma)-> new Note().setId(ma.getInt("id")).
                            setName(ma.getString("name")).
                            setDescription(ma.getString("description")).
                            setTime(ma.getObject("time", LocalDateTime.class)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(String name, String description, LocalDateTime time) {
        try {
            template.update(
                    "INSERT INTO notes(name, description, time) VALUES(?,?,?)",
                    new Object[]{name,description,time}
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            template.update(
                    "DELETE FROM notes WHERE id = ?",
                    new Object[]{id}
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
