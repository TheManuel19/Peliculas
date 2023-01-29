package com.edu.mx.pelicula.controller;

import com.edu.mx.pelicula.model.bean.BeanPelicula;
import com.edu.mx.pelicula.model.dao.DaoPelicula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ServletPelicula", urlPatterns = {"/listar","/crear","modificar","eliminar"})
public class ServletPelicula extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BeanPelicula> peliculas = new DaoPelicula().consultarPeliculas();
        req.setAttribute("listaPeliculas", peliculas);
        req.getRequestDispatcher("views/listar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion =  req.getParameter("accion");
        DaoPelicula dao = new DaoPelicula();

        switch (accion){
            case "crear":
                String fechaStr = req.getParameter("fecha");
                Date fecha = Date.valueOf(fechaStr);
                if (dao.crearPelicula(new BeanPelicula(
                        req.getParameter("titulo"),
                        req.getParameter("categoria"),
                        req.getParameter("descripcion"),
                        fecha,
                        req.getParameter("duracion"),
                        req.getParameter("autor")
                ))) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }
                break;
            case "modificar":
                if (dao.modificarPelicula(new BeanPelicula(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("titulo"),
                        req.getParameter("categoria"),
                        req.getParameter("descripcion"),
                        Date.valueOf(req.getParameter("fecha")),
                        req.getParameter("duracion"),
                        req.getParameter("autor")
                ))){
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("error");
                }
                break;
            case "eliminar":
                if (dao.eliminarPelicula(Integer.parseInt(req.getParameter("id")))){
                    System.out.println("success");
                }else{
                    System.out.println("error");
                }
                break;

    }
    resp.sendRedirect(req.getContextPath()+"/listar");
}
}
