<body>
	<%@include file="/WEB-INF/views/menu.jsp" %>
	<div class="container mt-5 pt-3">
		<c:if test="${! empty listUser }">
			<form action="historique" method="post">
				<div class="input-group mb-3">
					  <span class="input-group-text">sélectionner l'apprenant</span>
					  <select class="form-select form-control" required name="id_user">
						  <option value="">sélectionner l'apprenant</option>
						  <c:forEach items="${ listUser }" var="user">
						  	<option value="${ user.id }" <c:if test="${ user.id == succes }">selected</c:if>>
							  ${user.nom} ${user.prenom}
							</option>
						  </c:forEach>
						</select>
						<button class="btn btn-primary" type="submit">sélectionner</button>
				</div>
			</form>
			<c:if test="${! empty succes }">
				<c:choose>
					<c:when test="${! empty listReservation }">
						<table class="table table-striped mt-5">
							<thead>
								<tr>
									<th scope="col">date réservation</th>
									<th scope="col">horaire d'accès</th>
									<th scope="col">état</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="reservation" items="${listReservation}">
									<tr>
										<th scope="row"><fmt:formatDate type = "date" value = "${reservation.id.reserver.dateReserver}" /></th>
										<td>du ${reservation.id.reserver.duree}</td>
										<td>
											<c:choose>
												<c:when test="${ reservation.etat == 0 }">en attente</c:when>
												<c:when test="${ reservation.etat == 1 }">approuvée</c:when>
												<c:otherwise>rejetée</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h2 class="text-center mt-5">Il n'y a aucune demande d'accès pour cet apprenant</h2>
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:if>
		<c:if test="${empty listUser }">
			<h2 class="text-center mt-5">Il n'y a pas des apprenants</h2>
		</c:if>
	</div>
</body>
</html>