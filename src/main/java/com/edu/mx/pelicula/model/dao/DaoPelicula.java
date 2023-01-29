package com.edu.mx.pelicula.model.dao;

import com.edu.mx.pelicula.model.bean.BeanPelicula;
import com.edu.mx.pelicula.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPelicula {

    public List<BeanPelicula> consultarPeliculas() {
        List<BeanPelicula> lista = new ArrayList<>();
        String query = "SELECT * FROM peliculas";
        try {
            Connection c = new Conexion().createConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                BeanPelicula pelicula = new BeanPelicula(
                        res.getInt("id"),
                        res.getString("titulo"),
                        res.getString("categoria"),
                        res.getString("descripcion"),
                        res.getDate("fecha_de_estreno"),
                        res.getString("duracion"),
                        res.getString("autor")
                );
                lista.add(pelicula);
            }
            c.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        for (BeanPelicula pelis: lista) {
            System.out.println(pelis);
        }
        return lista;
    }

    public BeanPelicula consultarPeliculaId(int id) {
        BeanPelicula pelicula= new BeanPelicula();
        String query = "select * from peliculas p where (id = ?);";
        try {
            Connection c = new Conexion().createConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                pelicula = new BeanPelicula();
                pelicula.setId(res.getInt("id"));
                pelicula.setTitulo(res.getString("titulo"));
                pelicula.setCategoria(res.getString("categoria"));
                pelicula.setDescripcion(res.getString("descripcion"));
                pelicula.setFechaEstreno(res.getDate("fecha_de_estreno"));
                pelicula.setDuracion(res.getString("duracion"));
                pelicula.setAutor(res.getString("autor"));
            }
            c.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pelicula;
    }

    public boolean crearPelicula(BeanPelicula peliculaBean) {
        String query = "insert into peliculas (titulo,categoria,descripcion,fecha_de_estreno,duracion,autor)\n" +
                "values(?,?,?,?,?,?);\n";
        boolean exec = false;
        try {
            Connection c = new Conexion().createConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, peliculaBean.getTitulo());
            ps.setString(2, peliculaBean.getCategoria());
            ps.setString(3, peliculaBean.getDescripcion());
            ps.setDate(4, (Date) peliculaBean.getFechaEstreno());
            ps.setString(5, peliculaBean.getDuracion());
            ps.setString(6, peliculaBean.getAutor());

            int res = ps.executeUpdate();
            exec = (res>0)?true:false;
            c.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return exec;
    }

    public boolean eliminarPelicula(int id) {
        boolean respuesta = false;
        String query = "DELETE FROM peliculas where (id=?)";
        try{
            Connection c = new Conexion().createConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            respuesta  =  (res>0)?true:false;
        }catch (Exception e){
            System.out.println(e);
        }
        return respuesta;
    }

    public boolean modificarPelicula(BeanPelicula peliculaBean) {
        boolean respuesta = false;
        String query = "UPDATE peliculas SET titulo = ?," +
                " categoria = ? ,descripcion = ?, fecha_de_estreno = ?," +
                " duracion = ?, autor = ? WHERE (id = ?);\n";
        try {
            Connection c = new Conexion().createConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, peliculaBean.getTitulo());
            ps.setString(2, peliculaBean.getCategoria());
            ps.setString(3, peliculaBean.getDescripcion());
            ps.setDate(4, peliculaBean.getFechaEstreno());
            ps.setString(5, peliculaBean.getDuracion());
            ps.setString(6, peliculaBean.getAutor());
            ps.setLong(7, peliculaBean.getId());
            int resultado = ps.executeUpdate();
            respuesta = (resultado > 0 ? true : false);
        } catch (Exception e) {
            System.out.println(e);
        }
        return respuesta;
    }
}
