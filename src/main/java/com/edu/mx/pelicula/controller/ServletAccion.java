package com.edu.mx.pelicula.controller;

import com.edu.mx.pelicula.model.bean.BeanPelicula;
import com.edu.mx.pelicula.model.dao.DaoPelicula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletAccion", urlPatterns = {"/formCrear","/formModificar"})
public class ServletAccion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/crear.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BeanPelicula pelicula = new DaoPelicula().consultarPeliculaId(id);
        req.setAttribute("pelicula",pelicula);
        req.getRequestDispatcher("views/modificar.jsp").forward(req, resp);

    }
}
