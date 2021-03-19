package com.company.webapp.servlets;

import com.company.webapp.dto.Note;
import com.company.webapp.dto.StatusResponse;
import com.company.webapp.factory.ObjectFactory;
import com.company.webapp.services.NoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
public class GetPost extends JsonServlet {


    private final NoteService noteService = ObjectFactory.instance().getNoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Note> notes = noteService.getAll();
        if (notes == null || notes.isEmpty()) {
            writeJson(new StatusResponse().setStatus("error").
                    setError("Notes not found!"), resp);
        } else {
            for (Note note: notes) {
                //resp.getWriter().println(note);
                //resp.getWriter().flush();
                writeJson(new StatusResponse().setStatus("ok").setNote(note), resp);
            }


        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Note note = readJson(Note.class, req);
            noteService.add(note.getName(),
                    note.getDescription(),
                    LocalDateTime.now());
    }


}
