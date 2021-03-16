<body>
	<%@include file="/WEB-INF/views/menu.jsp" %>
	<div class="content">
		<div class="row g-0 mt-5 pl-5">
			<div class="col-6"><img alt="2" src="resources/img/2.png" class="image-index"></div>
			<div class="col-6 pt-5 pl-5">
				<c:if test="${! empty erreur }">
					<div class="alert alert-danger" role="alert">${erreur}</div>
				</c:if>
				<div class="register-show pt-5 pl-5">
					<h2>Inscription</h2>
					<form action="inscription" method="post">
					<input type="text" placeholder="Nom" name="nom" minlength="4" required>
					<input type="text" placeholder="Prenom" name="prenom" minlength="4" required>
						<input type="email" placeholder="Email" name="email" required>
						<input type="password" placeholder="Mot de passe" name="password" minlength="8" required>
						<button type="submit" class="btn btn-primary">Inscription</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>