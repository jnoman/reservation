<body>
	<%@include file="/WEB-INF/views/menu.jsp" %>
	<div class="container mt-5 pt-3">
		<c:if test="${! empty listUser }">
			<form action="historique" method="post">
				<div class="input-group mb-3">
					  <span class="input-group-text">s�lectionner l'apprenant</span>
					  <select class="form-select form-control" required name="id_user">
						  <option value="">s�lectionner l'apprenant</option>
						  <c:forEach items="${ listUser }" var="user">
						  	<option value="${ user.id }" <c:if test="${ user.id == succes }">selected</c:if>>
							  ${user.nom} ${user.prenom}
							</option>
						  </c:forEach>
						</select>
						<button class="btn btn-primary" type="submit">s�lectionner</button>
				</div>
			</form>
			<c:if test="${! empty succes }">
				<c:choose>
					<c:when test="${! empty listReservation }">
						<table class="table table-striped mt-5">
							<thead>
								<tr>
									<th scope="col">date r�servation</th>
									<th scope="col">horaire d'acc�s</th>
									<th scope="col">�tat</th>
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
												<c:when test="${ reservation.etat == 1 }">approuv�e</c:when>
												<c:otherwise>rejet�e</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h2 class="text-center mt-5">Il n'y a aucune demande d'acc�s pour cet apprenant</h2>
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