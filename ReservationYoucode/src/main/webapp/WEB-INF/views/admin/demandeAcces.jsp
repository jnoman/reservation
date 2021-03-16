<body>
	<%@include file="/WEB-INF/views/menu.jsp" %>
	<div class="container mt-5 pt-3">
		<c:if test="${! empty listReserver }">
			<form action="demandeAcces" method="post">
				<div class="input-group mb-3">
					  <span class="input-group-text">sélectionner la date</span>
					  <select class="form-select form-control" required name="id_reserver">
						  <option value="">sélectionner la date</option>
						  <c:forEach items="${ listReserver }" var="reserver">
						  	<option value="${ reserver.id }" <c:if test="${ reserver.id == succes }">selected</c:if>>				  		
						  	<fmt:formatDate type = "date" value = "${reserver.dateReserver}" />
						  		 du ${reserver.duree}
						  	</option>
						  </c:forEach>
						</select>
						<button class="btn btn-primary" type="submit" name="selectionner">sélectionner</button>
				</div>
			</form>
			<c:forEach items="${ listReserver }" var="reserver">
				<c:if test="${ reserver.id == succes }">
					<h2 class="mt-5">nombre de place : ${ reserver.nombrePlace }</h2>
				</c:if>
			</c:forEach>
			<c:if test="${! empty succes }">
				<c:choose>
					<c:when test="${! empty listDemande }">
						<table class="table table-striped mt-5">
							<thead>
								<tr>
									<th scope="col">nom apprenant</th>
									<th scope="col">accepter</th>
									<th scope="col">refuser</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="demande" items="${listDemande}">
									<tr>
										<th scope="row">${demande.id.user.nom} ${demande.id.user.prenom}</th>
										<td>
											<form action="demandeAcces" method="post">
												<input name="user_id" type="hidden" value="${ demande.id.user.id }">
												<input name="reserver_id" type="hidden" value="${ demande.id.reserver.id }">
												<button type="submit" name="accepter" class="btn btn-primary">accepter</button>
											</form>
										</td>
										<td>
											<form action="demandeAcces" method="post">
												<input name="user_id" type="hidden" value="${ demande.id.user.id }">
												<input name="reserver_id" type="hidden" value="${ demande.id.reserver.id }">
												<button type="submit" name="refuser" class="btn btn-danger">refuser</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h2 class="text-center mt-5">Il n'y a pas des demandes d'accès pour ce jour</h2>
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:if>
		<c:if test="${empty listReserver }">
			<h2 class="text-center mt-5">Les jours pendant lesquels les apprenants peut demander l'accès n'ont pas encore été déterminés</h2>
		</c:if>
	</div>
</body>
</html>