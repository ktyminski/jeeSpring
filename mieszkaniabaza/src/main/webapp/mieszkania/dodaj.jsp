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
						    url: '${pageContext.request.contextPath}/rest/mieszkania/dodaj',
						    type: 'POST',
						    data:
							{
								wynajmujacy: document.getElementById('wynajmujacy').value,
								ulica: document.getElementById('ulica').value,
								cena: document.getElementById('cena').value,
								opis: document.getElementById('opis').value
								
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/Mieszkania"); },
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
        <h1 class="text-center">Dodaj Mieszkanie</h1>
            	<form data-toggle="validator" method="post" class="form-horizontal">

		    

		        <div class="form-group">
		         	<label for="wynajmujacy" class="col-sm-2 control-label">Wlasciciel:</label>
				<div class="col-sm-10">
				         <select type="text" name="wynajmujacy" id="wynajmujacy" class="form-control" required>
				     		<c:forEach var="wynajmujacyFK" items="${wynajmujacywszystkie}" varStatus="loopCounter">
						    	<option value="${wynajmujacyFK.id}">${wynajmujacyFK.getNazwisko()}</option>
					    	</c:forEach>
					</select>
				</div>
				
				 <div class="form-group">
		           	<label for="ulica" class="col-sm-2 control-label">ulica:</label>

		            	<div class="col-sm-10">
		                	<input type="text" name="ulica" min="2" id="ulica" class="form-control"/>
		            	</div>
		        </div>
		        </div>

		        <div class="form-group">
		            	<label for="cena" class="col-sm-2 control-label" >Cena:</label>

		            	<div class="col-sm-10">
		                	<input type="text" pattern="^[0-9]+$|^[0-9]+[.][0-9]+$" name="cena" id="cena" class="form-control" placeholder="0.0" required>
		            	</div>
		        </div>

		        <div class="form-group">
		           	<label for="opis" class="col-sm-2 control-label">Opis:</label>

		            	<div class="col-sm-10">
		                	<input type="text" name="opis" min="2" id="opis" class="form-control"/>
		            	</div>
		        </div>
		        <div class="form-group text-center">
		                <button id="dodaj" type="submit" class="btn btn-success">Dodaj</button>
				<a href="${pageContext.request.contextPath}/Mieszkania" class="btn btn-default" role="button">Wróć</a>
		        </div>

            	</form>

    <jsp:include page="../elementy/stopka.jsp" />
</div>
</body>
</html>
