 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<link rel="shortcut icon" href="css/favicon.ico?" type="image/x-icon" />
	<title>NaCaneta! Cotação Escolar</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen'
		href='css/style.css'>
</head>

<body>
	<!-- Main Content -->
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
					<div class="inputs">
						<label for="escola"><b>Escola</b><span class="addNew" id="add_escola">&#9998; adicionar escola</span></label> 
						<form:select path="escola" id="escola">
							<form:option value="-" label="Escola"/>
							<form:options items="${escola}" itemValue="nome" itemLabel="nome"/>
						</form:select>	
						<label for="listamaterial"><b>Lista de Material</b><span class="addNew" id="add_lista">&#9783; adicionar lista</span></label> 
						<form:select path="listaMaterial" id="listaMaterial" disabled="true">
							<form:option value="-" label="Lista de Material"/>
							<form:options items="${listaMaterial}" itemValue="serie" itemLabel="serie"/>
						</form:select>
						<label for="loja"><b>Loja/Papelaria</b><span class="addNew" id="add_loja">&#36; adicionar loja</span></label>
						<form:select path="loja" id= "loja" disabled="true">
							<form:option value="-" label="Loja/Papelaria"/>
							<form:options items="${loja}" itemValue="nome" itemLabel="nome"/>
						</form:select>						
						
						<label for="valor"><b>Preço Total</b></label>
						<input type="text" id="valor" placeholder="200,00" disabled="disabled">
						<div class="formButtons">
							<button type="button" onclick="cleanForm(this)">limpar</button>
							<button type="submit">salvar</button>
						</div>
					</div>
				</form>
			</div>
			<div class="sideBar">
				<h1 class="tituloSide">Cotações</h1>
				<ul class="listaSide">
					<li>Teste: Id #${cotacao.get(0).getId()}</li>
				</ul>
			</div>
		</main>
	</div>
	<!-- The Modal -->
	<div id="myModal" class="modal">
	  <span class="close">&times;</span>
	  <div class="modal-content" id="modal_content">
	  </div>
	</div>
	<script charset="UTF-8" src='js/script.js'></script>
</body>

</html>
