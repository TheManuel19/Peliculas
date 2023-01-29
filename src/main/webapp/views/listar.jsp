<%--
  Created by IntelliJ IDEA.
  User: ruben
  Date: 27/01/2023
  Time: 04:49 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
<table class="table table-striped table-dark text-center">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Título de la película</th>
        <th scope="col">Categoría</th>
        <th scope="col">Descripción</th>
        <th scope="col">Fecha de Estreno</th>
        <th scope="col">Duración</th>
        <th scope="col">Autor</th>
        <th scope="col">Modificar</th>
        <th scope="col">Eliminar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="listaPeliculas" items="${listaPeliculas}" varStatus="loop">
        <tr>
            <td>${listaPeliculas.id}</td>
            <td>${listaPeliculas.titulo}</td>
            <td>${listaPeliculas.categoria}</td>
            <td>${listaPeliculas.descripcion}</td>
            <td>${listaPeliculas.fechaEstreno}</td>
            <td>${listaPeliculas.duracion}</td>
            <td>${listaPeliculas.autor}</td>
            <td>
                <form action="${context}/formModificar" method="post">
                    <input type="hidden" name="id" value="${listaPeliculas.id}">
                    <button class="btn btn-warning" type="submit">
                        <img src="${context}/assets/icons/pencil.svg" width="24" height="24">
                    </button>
                </form>
            </td>
            <td>
                <form action="${context}/eliminar" method="post">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="id" value="${listaPeliculas.id}">
                    <button class="btn btn-danger" type="submit">
                        <img src="${context}/assets/icons/trash.svg" width="24" height="24">
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
