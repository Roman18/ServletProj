package com.company.webapp.servlets;

import com.company.webapp.dto.Note;
import com.company.webapp.dto.StatusResponse;
import com.company.webapp.factory.ObjectFactory;
import com.company.webapp.services.NoteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class GetPost extends JsonServlet {


    private final NoteService noteService = ObjectFactory.instance().getNoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Note> notes = noteService.getAll();
        req.setAttribute("notes", notes);
        req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Note note = new Note().
                setName(req.getParameter("name")).
                setDescription(req.getParameter("description"));
        noteService.add(note.getName(),
                note.getDescription(),
                LocalDateTime.now());
        resp.sendRedirect(req.getContextPath()+"/notes");
    }


}
