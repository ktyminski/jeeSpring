<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    	<jsp:include page="../elementy/head.jsp" />
	<jsp:include page="../elementy/skrypty.jsp" />
	<script>
		$(document).ready(function()
			{
				$( "#dodaj" ).on('click', function(e)
					{	
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/rest/wynajmujacy/dodaj',
						    type: 'POST',
						    data:
							{
								imie: document.getElementById('imie').value,
								nazwisko: document.getElementById('nazwisko').value,
								pesel: document.getElementById('pesel').value
								
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/Wynajmujacy"); },
 						    error: function() { alert("Złe dane!"); }
						}		
						);
					}
				);
			}
		);
	</script>
</head>

<body>
<jsp:include page="../elementy/menu.jsp" />

<div class="container">
    <div class="row">
        <h1 class="text-center">Dodaj Wynajmujacego</h1>

        	<form action="${pageContext.request.contextPath}/rest/wynajmujacy/dodaj" data-toggle="validator" method="post" class="form-horizontal">
		        <div class="form-group">
		            <label for="imie" class="col-sm-2 control-label">Imie:</label>

		            <div class="col-sm-10">
		                <input type="text" name="imie" id="imie" class="form-control" data-minlength="2" required>
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="nazwisko" class="col-sm-2 control-label">Nazwisko:</label>

		            <div class="col-sm-10">
		                <input type="text" name="nazwisko" id="nazwisko"  class="form-control"  data-minlength="2" required>
		            </div>
		        </div>

		         <div class="form-group">
		            <label for="pesel" class="col-sm-2 control-label">Pesel:</label>

		            <div class="col-sm-10">
		                <input type="text" name="pesel" id="pesel" pattern="^[0-9]+$" class="form-control"  required>
		            </div>
		        </div>
		        <div class="form-group text-center">
		                <button id="dodaj" type="submit" class="btn btn-success">Dodaj</button>
				<a href="${pageContext.request.contextPath}/Wynajmujacy" class="btn btn-default" role="button">Wróć</a>
		 	    </div>
		        </div>
            	</form>

    <jsp:include page="../elementy/stopka.jsp" />
</div>

</body>
</html>
