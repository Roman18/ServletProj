package com.company.webapp.servlets;

import com.company.webapp.dto.DeleteRequest;
import com.company.webapp.factory.ObjectFactory;
import com.company.webapp.services.NoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Delete extends JsonServlet {
    private final NoteService noteService = ObjectFactory.instance().getNoteService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                DeleteRequest deleteReq = readJson(DeleteRequest.class, req);

                noteService.delete(Integer.parseInt(deleteReq.getId()));
    }
}
