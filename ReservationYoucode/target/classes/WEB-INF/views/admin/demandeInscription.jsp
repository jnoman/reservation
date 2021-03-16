<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container mt-5 pt-3">
		<c:if test="${! empty listUser }">
			<table class="table table-striped mt-5">
				<thead>
					<tr>
						<th scope="col">email</th>
						<th scope="col">nom</th>
						<th scope="col">prenom</th>
						<th scope="col">accepter</th>
						<th scope="col">refuser</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUser}">
						<tr>
							<th scope="row">${ user.email }</th>
							<td>${ user.nom }</td>
							<td>${ user.prenom }</td>
							<td>
								<form action="demandeInscription" method="post">
									<input name="id" type="hidden" value="${ user.id }">
									<button type="submit" name="accepter" class="btn btn-primary">accepter</button>
								</form>
							</td>
							<td>
								<form action="demandeInscription" method="post">
									<input name="id" type="hidden" value="${ user.id }">
									<button type="submit" name="refuser" class="btn btn-danger">refuser</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty listUser }">
			<h2 class="text-center pt-3">Aucune demande d'inscription</h2>
		</c:if>
	</div>
</body>
</html>