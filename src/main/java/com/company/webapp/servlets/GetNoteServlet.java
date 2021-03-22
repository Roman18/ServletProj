package com.company.webapp.servlets;

import com.company.webapp.dto.Note;
import com.company.webapp.factory.ObjectFactory;
import com.company.webapp.services.NoteService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetNoteServlet extends HttpServlet {

    private final NoteService noteService = ObjectFactory.instance().getNoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int start = req.getRequestURI().lastIndexOf("/");
        Integer id = Integer.parseInt(req.getRequestURI().substring(start+1));
        Note note =noteService.get(id);
        req.setAttribute("note", note);
        try {

            getServletContext().getRequestDispatcher("/WEB-INF/views/note.jsp").forward(req, resp);
        }catch (ServletException e){
            e.printStackTrace();
        }
    }
}
