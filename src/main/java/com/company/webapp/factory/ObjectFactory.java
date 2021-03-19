package com.company.webapp.factory;

import com.company.webapp.db.JdbcTemplate;
import com.company.webapp.db.SetUpDB;
import com.company.webapp.services.DbNoteService;
import com.company.webapp.services.NoteService;

public class ObjectFactory {

    private static final ObjectFactory INSTANCE = new ObjectFactory();

    public static ObjectFactory instance(){
        return INSTANCE;
    }



    private NoteService noteService;

    private ObjectFactory(){
        SetUpDB setUp = new SetUpDB();
        JdbcTemplate template = new JdbcTemplate(setUp.getDataSource());
        this.noteService = new DbNoteService(template);
    }

    public NoteService getNoteService() {
        return this.noteService;
    }
}
