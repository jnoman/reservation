<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand"
			href="${pageContext.servletContext.contextPath}">
				<img alt="youcode" src="${pageContext.servletContext.contextPath}/resources/img/white.png" />
			</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<c:choose>
				<c:when test="${! empty sessionScope.logged }">
					<c:choose>
						<c:when test="${sessionScope.logged.role =='admin' }">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/demandeInscription">Demandes d'inscription</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/demandeAcces">Demandes d'accés</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/nombrePlace">Nombre de place</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/historique">L'historique</a>
								</li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.servletContext.contextPath}/user/demandesAcces">Demandes d'accés</a>
								</li>
							</ul>
						</c:otherwise>
					</c:choose>
					<form class="d-flex"
						style="width: 100%; display: inline-block !important;"
						action="${pageContext.servletContext.contextPath}/deconnexion" method="get">
						<button class="btn btn-outline-light" style="float: right;"
							type="submit">Déconnexion</button>
					</form>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath}">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath}/connexion">Connexion</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath}/inscription">Inscription</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
