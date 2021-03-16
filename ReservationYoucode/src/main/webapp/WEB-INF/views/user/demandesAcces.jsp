<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container mt-5 pt-3">
		<c:if test="${! empty succes }">
			<div class="alert alert-success" role="alert">${succes }</div>
		</c:if>
		<c:if test="${! empty listReserver }">
			<form action="demandesAcces" method="post">
				<div class="input-group mb-3">
					  <span class="input-group-text">sélectionner la date</span>
					  <select class="form-select form-control" required name="id_reserver">
						  <option value="">sélectionner la date</option>
						  <c:forEach items="${ listReserver }" var="reserver">
						  	<option value="${ reserver.id }"> 
						  		<fmt:formatDate type = "date" value = "${reserver.dateReserver}" />
						  		 du ${reserver.duree}
						  	</option>
						  </c:forEach>
						</select>
						<button class="btn btn-primary" type="submit" id="button-addon2">ajouter</button>
				</div>
			</form>
		</c:if>
		<c:if test="${! empty listDemande }">
			<table class="table table-striped mt-5">
				<thead>
					<tr>
						<th scope="col">date demande</th>
						<th scope="col">horaire d'accès</th>
						<th scope="col">état de demande</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="demande" items="${listDemande}">
						<tr>
							<th scope="row"><fmt:formatDate type = "date" value = "${demande.id.reserver.dateReserver}" /></th>
							<td>du ${ demande.id.reserver.duree }</td>
							<td>
								<c:choose>
									<c:when test="${ demande.etat == 0 }">en attente</c:when>
									<c:when test="${ demande.etat == 1 }">approuvée</c:when>
									<c:otherwise>rejetée</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty listDemande }">
			<h2 class="text-center mt-5">Vous n'avez encore fait aucune demande</h2>
		</c:if>
	</div>
</body>
</html>