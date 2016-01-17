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
				$( "#edytuj" ).on('click', function(e)
					{	
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/rest/mieszkania/edytuj/${mieszkaniaedited.getId()}',
						    type: 'PUT',
						    data:
							{
								
								
								wynajmujacy: document.getElementById('wynajmujacy').value,
								ulica: document.getElementById('ulica').value,
								cena: document.getElementById('cena').value,
								opis: document.getElementById('opis').value
								
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/Mieszkania"); },
 						    error: function() { alert("Nieprawidłowo wprowadzono dane!"); }
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
        <h1 class="text-center">Edytuj Mieszkanie</h1>
            	<form data-toggle="validator" method="put" class="form-horizontal">

		        
		         	<label for="wynajmujacy" class="col-sm-2 control-label">Wynajmujacy:</label>
				<div class="col-sm-10">
				         <select type="text" name="wynajmujacy" id="wynajmujacy" class="form-control" required>
				     		<c:forEach var="wynajmujacyFK" items="${wynajmujacywszystkie}" varStatus="loopCounter">
						<c:choose>
						    <c:when test="${trumnaFK.id == mieszkaniaedited.getWynajmujacy().getId()}">
						    	<option value="${wynajmujacyFK.id}" selected="selected">${wynajmujacyFK.getNazwisko()}</option>
						    </c:when>
						    <c:otherwise>
							<option value="${wynajmujacyFK.id}">${wynajmujacyFK.nazwisko}</option>
							<br />
						    </c:otherwise>
						</c:choose>
					</c:forEach>
					</select>
				</div>
		        </div>
		        <div class="form-group">
		           	<label for="opis" class="col-sm-2 control-label" min="2">Ulica:</label>

		            	<div class="col-sm-10">
		                	<input type="text" name="opis" id="opis" class="form-control" value="${mieszkaniaedited.getUlica()}">
		            	</div>
		        </div>

		        <div class="form-group">
		            	<label for="cena" class="col-sm-2 control-label" >Cena:</label>

		            	<div class="col-sm-10">
		                	<input type="text" pattern="^[0-9]+$|^[0-9]+[.][0-9]+$" name="cena" id="cena" class="form-control" value="${mieszkaniaedited.getCena()}" placeholder="0.0" required>
		            	</div>
		        </div>

		        <div class="form-group">
		           	<label for="opis" class="col-sm-2 control-label" min="2">Opis:</label>

		            	<div class="col-sm-10">
		                	<input type="text" name="opis" id="opis" class="form-control" value="${mieszkaniaedited.getOpis()}">
		            	</div>
		        </div>
		        <div class="form-group text-center">
		                <button id="edytuj" type="submit" class="btn btn-primary">Edytuj</button>
				<a href="${pageContext.request.contextPath}/Mieszkania" class="btn btn-default" role="button">Wróć</a>
		        </div>

            	</form>

    <jsp:include page="../elementy/stopka.jsp" />
</div>
</body>
</html>
