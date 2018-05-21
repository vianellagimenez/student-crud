<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alumnos</title>
		<script src="../resources/js/jquery-3.1.1.min.js"></script>
        <script src="../resources/js/popper.min.js"></script>
        <script src="../resources/js/bootstrap.min.js"></script>
        <script src="../resources/js/script.js"></script>
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resources/css/style.css">
	</head>
	
	<body onload="load();">
		<div class="container">
			<h2>Alumnos</h2>
			
			<input id="id" type="hidden">
			
			<div class="form-group">
				<label for="name">Nombre:</label>
				<input id="nombre" type="text" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="apellido">Apellido:</label>
				<input id="apellido" type="text" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="documento">Documento:</label>
				<input id="documento" type="text" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="carreras_id">Carrera:</label>
				<select id="carreras_id" class="form-control"></select>
			</div>
			
			<button onclick="save();" class="btn btn-primary">Guardar</button>
			
			<table id="table" class="table">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Documento</th>
					<th>Carrera</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</table>
		</div>
	</body>
</html>