<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <link rel="shortcut icon" href="css/favicon.ico?" type="image/x-icon" />
    <title>NaCaneta! Cotação Escolar</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='css/style.css'>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>

<body>
    <!--Grid Wrapper-->
    <div class="wrapper">
        <!--Header-->
        <div class="header">
            <!--Logo-->
            <div class="logo">
                <a id="logo" href="#">NaCaneta!</a>
            </div>

            <!--Profile-->
            <div class="profile">
                <div class="avatar">
                    <img id="avatar_img" src="css/avatar.png" />
                </div>
                <div class="profile_info">
                    <span id="username"><b>@usuário</b></span>
                </div>
            </div>
        </div>

        <!--Main-->
        <div class="main">
        	<div class="main_nav">
	        	<ul class="list_nav">
		        	<li>
       					<img class="nav_icon" src="css/cotacao.png" />
       					<span class="nav_tag">cotações</span>
		        	</li>
		        	<li>
		        		<img class="nav_icon" src="css/escola.png" />
       					<span class="nav_tag">escolas</span>
		        	</li>
		        	<li>
		        		<img class="nav_icon" src="css/lista.png" />
       					<span class="nav_tag">listas de material</span>
		        	</li>
		        	<li>
		        		<img class="nav_icon" src="css/loja.png" />
       					<span class="nav_tag">lojas e papelarias</span>
		        	</li>
	        	</ul>
        	</div>
            <div class="main_content">
                <h1 class="main_title">Registrar Cotação</h1>
                <form id="registrarCotacao" class="main_form" method="post">
                    <div class="form_inputs">
                        <label for="escola"><b>Escola</b><span class="add_button" id="add_escola">&#9998; adicionar
                                escola</span></label>
                        <select id="escola" name="escola" >
                            <option value="-">escola</option>
                        </select>
                        <span class="refresh" onclick="listEscolas()">&#10227;</span>

                        <label for="listamaterial"><b>Lista de Material</b><span class="add_button"
                                id="add_lista">&#9783;
                                adicionar lista</span></label>
                        <select id="listaMaterial" name="lista" disabled="disabled" >
                            <option value="-">lista</option>
                        </select>
                        <span class="refresh" onclick="listListasMaterialbyEscola(escola.value)">&#10227;</span>

                        <label for="loja"><b>Loja/Papelaria</b><span class="add_button" id="add_loja">&#36; adicionar
                                loja</span></label>
                        <select id="loja" name="loja" disabled="disabled" >
                            <option value="-">loja</option>
                        </select>
                        <span class="refresh" onclick="listLojas()">&#10227;</span>

                        <label for="valor"><b>Preço Total (R$)</b></label>
                        <input type="text" id="valor" name="valor" placeholder="200,00" disabled="disabled" required>

                        <div class="form_buttons">
                            <button type="button" onclick="cleanForm(this)"><span>limpar</span></button>
                            <button type="submit" disabled="disabled" id="submit_btn"><span>salvar</span></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!--SideBar-->
        <div class="sidebar">
            <h1 class="title_side">Cotações <span class="refresh" onclick="listCotacoes()">&#10227;</span></h1>
            <ul class="list_side" id="list_cotacoes">
            </ul>
        </div>
    </div>

    <!-- The Modal -->
    <div class="form_modal" id="form_modal">
        <span class="close_modal" id="close_modal">&times;</span>
        <div class="content_modal" id="content_modal">
        </div>
    </div>
</body>
<script src="js/script.js" charset="UTF-8"></script>

</html>