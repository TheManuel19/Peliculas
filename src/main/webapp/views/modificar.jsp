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
  <form method="post" action="${pageContext.request.contextPath}/modificar">
    <div class="form-row">
      <div class="form-group col-md-4">
        <label for="titulo" autofocus>Titulo</label>
        <input type="text"  name="titulo" id="titulo" class="form-control" value="${pelicula.titulo}">
      </div>
      <div class="form-group col-md-4">
        <label for="categoria" autofocus>Categoria</label>
        <input type="text"  name="categoria" id="categoria" class="form-control" value="${pelicula.categoria}">
      </div>
      <div class="form-group text-center col-md-6">
        <label for="descripcion" autofocus>Descripción</label>
        <input type="text" name="descripcion" id="descripcion" class="form-control" value="${pelicula.descripcion}">
      </div>
    </div>
    <div class="form-row">
      <div class="form-group col-md-4">
        <label for="fecha" autofocus>Fecha de estreno</label>
        <input type="date" name="fecha" id="fecha" class="form-control" value="${pelicula.fechaEstreno}">
      </div>
      <div class="form-group col-md-4">
        <label for="duracion" autofocus>Duración</label>
        <input type="time" name="duracion" id="duracion" max="08:00:00" min="00:00:00" class="form-control without_ampm"
               value="${pelicula.duracion}">
      </div>
      <div class="form-group col-md-4">
        <label for="autor" autofocus>Autor</label>
        <input type="text" name="autor" id="autor" class="form-control" value="${pelicula.autor}">
      </div>
    </div>
    <input type="hidden" value="${pelicula.id}" name="id">
    <input type="hidden" name="accion" value="modificar">
    <button type="submit" class="btn btn-primary">Modificar</button>
  </form>
</div>
</body>
</html>
