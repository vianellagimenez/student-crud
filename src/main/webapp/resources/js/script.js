$(document).ready(function() {
	data = "";
	
	save = function() {
		$.ajax({
			url: 'saveOrUpdate',
			type: 'POST',
			data: {
				id: $("#id").val(),
				nombre: $('#nombre').val(),
				apellido: $('#apellido').val(),
				nro_documento: $('#documento').val(),
				carreras_id: parseInt($('#carreras_id').val())
			},
			success: function(response) {
				alert(response.message);
				load();
				$("#id").val("");
				$('#nombre').val("")
				$('#apellido').val("");
				$('#documento').val("");
			}
		});
	}
	
	delete_ = function(id) {
		$.ajax({
			url: 'delete',
			type: 'POST',
			data: {
				id : id
			},
			success: function(response) {
				alert(response.message);
				load();
			}
		});
	}
	
	edit = function(index) {
		$("#id").val(data[index].id);
		$("#nombre").val(data[index].nombre);
		$("#apellido").val(data[index].apellido);
		$("#documento").val(data[index].nro_documento);
		$("#carreras_id").val(data[index].carreras_id.id);
	}
	
	load = function() {
		$.ajax({
			url: 'list',
			type: 'POST',
			success: function(response) {
				data = response.data;
				$('.tr').remove();
				
				for (i = 0; i < response.data.length; i++) {
					$("#table").append("<tr class='tr'> <td> "
					+ response.data[i].nombre
					+ " </td> <td> "
					+ response.data[i].apellido
					+ " </td> <td> "
					+ response.data[i].nro_documento
					+ " </td> <td> "
					+ response.data[i].carreras_id.descripcion
					+ " </td> <td> <a href='#' onclick= edit("
					+ i
					+ ");> Editar </a>  </td> </td> <td> <a href='#' onclick='delete_("
					+ response.data[i].id
					+ ");'> Eliminar </a>  </td> </tr>");
				}
			}
		});
		
		$.ajax({
			url: '../carreras/list',
			type: 'POST',
			success: function(response) {
				$('option').remove();
				
				for (i = 0; i < response.data.length; i++) {
					$("#carreras_id").append('<option value="' + response.data[i].id + '">' + response.data[i].descripcion + '</option>');
				}
			}
		});
	}
});