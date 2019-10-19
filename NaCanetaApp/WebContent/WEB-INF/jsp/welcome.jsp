<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<meta charset='UTF-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>NaCaneta!</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen'
	href='css/style.css'>
<script src='js/script.js'></script>
</head>

<body>
	<div class="container">
		<header class="cabecalhoPrincipal">
			<h1 class="cabecalhoPrincipal-logo">
				<a href="#">NaCaneta!</a>
			</h1>
			<nav class="cabecalhoPrincipal-nav">
				<a href="#" class="cabecalhoPrincipal-nav-link"></a>
			</nav>
		</header>
		<main class="conteudoPrincipal">
			<div class="mainBar">
				<h1 class="tituloPrincipal">Registrar Cotação</h1>
				<form class="myForm">
					<div class="contact">
						<label for="name"><b>Lista de Material</b></label> <select
							name="cars" id="name">
							<option value="volvo">PUC</option>
							<option value="saab">USP</option>
							<option value="fiat">UNICAMP</option>
						</select> <label for="townborn"><b>Papelaria/Loja</b></label> <select
							name="cars" id="townborn">
							<option value="volvo">PUC</option>
							<option value="saab">USP</option>
							<option value="fiat">UNICAMP</option>
						</select> <label for="email"><b>Preço Total</b></label> <input type="email"
							id="email">

						<button type="submit">limpar</button>
						<button type="submit">salvar</button>
					</div>
				</form>
			</div>
			<div class="sideBar">
				<h1 class="tituloSide">Cotações</h1>
				<ul class="listaSide">
					<li>${message}</li>
				</ul>
			</div>
		</main>
	</div>
</body>

</html>