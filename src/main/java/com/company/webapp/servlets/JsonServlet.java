package com.company.webapp.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonServlet extends HttpServlet {



    private final ObjectMapper mapper = new ObjectMapper();


    protected void writeJson(Object o, HttpServletResponse resp) throws IOException {
        try {
            resp.setHeader("Content-Type","application/json");
            //String strResponse = mapper.writeValueAsString(o);  так не работает,
            // просто ничего не выводит при GET запросе!!! Но когда записей в таблице нет и статус = "error",
            // то эта строка работает(((
            resp.getWriter().println(o.toString());
            resp.getWriter().flush();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    protected <T> T readJson(Class<T> clazz, HttpServletRequest req) throws IOException {
        return mapper.readValue(req.getInputStream(), clazz);

    }
}
