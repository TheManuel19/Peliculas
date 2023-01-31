<%--
  Created by IntelliJ IDEA.
  User: ruben
  Date: 28/01/2023
  Time: 07:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Modificar Película</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
  <div class="text-center d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h2 class="text-black-50">Modificar película</h2>
  </div>
  <form method="post" action="${pageContext.request.contextPath}/modificar" style="margin-top: 30px;margin-left: 240px">

      <div class="form-group row">
        <label for="titulo" class="col-sm-2 col-form-label" autofocus>Titulo</label>
        <div class="col-sm-6">
        <input type="text"  name="titulo" id="titulo" class="form-control" value="${pelicula.titulo}">
        </div>
      </div>
      <div class="form-group row mt-2">
        <label for="categoria" class="col-sm-2 col-form-label" autofocus>Categoria</label>
        <div class="col-sm-6">
        <input type="text"  name="categoria" id="categoria" class="form-control" value="${pelicula.categoria}">
        </div>
      </div>
      <div class="form-group row mt-2">
        <label for="descripcion" class="col-sm-2 col-form-label" autofocus>Descripción</label>
        <div class="col-sm-6">
        <textarea name="descripcion" id="descripcion" class="form-control" rows="2">${pelicula.descripcion}</textarea>
        </div>
      </div>
      <div class="form-group row mt-2">
        <label for="fecha" class="col-sm-2 col-form-label" autofocus>Fecha de estreno</label>
        <div class="col-sm-6">
        <input type="date" name="fecha" id="fecha" class="form-control" value="${pelicula.fechaEstreno}">
        </div>
      </div>
      <div class="form-group row mt-2">
        <label for="duracion" class="col-sm-2 col-form-label" autofocus>Duración</label>
        <div class="col-sm-6">
        <input type="time" name="duracion" id="duracion" max="08:00:00" min="00:00:00" class="form-control without_ampm"
               value="${pelicula.duracion}">
        </div>
      </div>
      <div class="form-group row mt-2">
        <label for="autor" class="col-sm-2 col-form-label" autofocus>Autor</label>
        <div class="col-sm-6">
        <input type="text" name="autor" id="autor" class="form-control" value="${pelicula.autor}">
        </div>
      </div>

    <input type="hidden" value="${pelicula.id}" name="id">
    <input type="hidden" name="accion" value="modificar">
    <div class="form-group row" style="margin-left: 165px">
      <div class="col-sm-7 row">
    <button type="submit" class="btn btn-primary">Modificar</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
