<body>
	<%@include file="/WEB-INF/views/menu.jsp" %>
	<div class="container mt-5 pt-3">
		<c:if test="${! empty succes }">
			<div class="alert alert-success" role="alert">${succes }</div>
		</c:if>
		<h2>entrez le nombre de places pour la semaine prochaine</h2>
		<form action="nombrePlace" method="post">
			<table class="table table-striped mt-5 mb-4">
				<thead>
					<tr>
						<th scope="col">jour</th>
						<th scope="col">horaire d'accès</th>
						<th scope="col">nombre de place</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">lundi</th>
						<td>du 17h-20h</td>
						<td><input type="number" name="lundi" required min="0"
							max="100" required></td>
					</tr>

					<tr>
						<th scope="row">mardi</th>
						<td>du 17h-20h</td>
						<td><input type="number" name="mardi" required min="0"
							max="100" required></td>
					</tr>

					<tr>
						<th scope="row">mercredi</th>
						<td>du 17h-20h</td>
						<td><input type="number" name="mercredi" required min="0"
							max="100" required></td>
					</tr>

					<tr>
						<th scope="row">jeudi</th>
						<td>du 17h-20h</td>
						<td><input type="number" name="jeudi" required min="0"
							max="100" required></td>
					</tr>

					<tr>
						<th scope="row">vendredi</th>
						<td>du 17h-20h</td>
						<td><input type="number" name="vendredi" required min="0"
							max="100" required></td>
					</tr>

					<tr>
						<th scope="row">samedi</th>
						<td>du 9h-20h</td>
						<td><input type="number" name="samedi" required min="0"
							max="100" required></td>
					</tr>

					<tr>
						<th scope="row">dimanche</th>
						<td>du 9h-20h</td>
						<td><input type="number" name="dimanche" required min="0"
							max="100" required></td>
					</tr>
				</tbody>
			</table>
			<c:choose>
				<c:when test="${ empty listReserver }">
					<button type="submit" name="ajouter" class="btn btn-primary">ajouter</button>
				</c:when>
				<c:otherwise>
					<button type="submit" name="modifier" class="btn btn-primary">modifier</button>
					<script type="text/javascript">
						$(function () {
							$('input[name="lundi"]').val(${ listReserver[0].nombrePlace });
							$('input[name="mardi"]').val(${ listReserver[1].nombrePlace });
							$('input[name="mercredi"]').val(${ listReserver[2].nombrePlace });
							$('input[name="jeudi"]').val(${ listReserver[3].nombrePlace });
							$('input[name="vendredi"]').val(${ listReserver[4].nombrePlace });
							$('input[name="samedi"]').val(${ listReserver[5].nombrePlace });
							$('input[name="dimanche"]').val(${ listReserver[6].nombrePlace });
						});
					</script>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
</body>
</html>