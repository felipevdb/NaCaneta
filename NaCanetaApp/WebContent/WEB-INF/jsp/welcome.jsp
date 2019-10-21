<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

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
						<label for="listamaterial"><b>Lista de Material</b></label> 
						<select
							name="listamaterial" id="listamaterial">
							<option value="Lista PUC">Lista PUC</option>
						</select>
						
						<form:select path="listaMaterial">
							<form:option value="-" label="listamaterial"/>
							<form:options items="${listaMaterial}" itemValue="serie" itemLabel="serie"/>
						</form:select>
						
						
						<label for="loja"><b>Papelaria/Loja</b></label> 
						<select
							name="loja" id="loja">
							<option value="Papelaria PUC">Papelaria PUC</option>
						</select> <label for="valor"><b>Preço Total</b></label> <input type="text"
							id="valor">
						<div class="formButtons">
							<button type="submit">limpar</button>
							<button type="submit">salvar</button>
						</div>
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