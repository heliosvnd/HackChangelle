<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=edge" />
  <title>Portal de Servicios Banco Azteca</title>
  <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>

<body ng-app="app" ng-controller="validarForm">

  <div class="pageHome">
    <div class="header">
      <div class="headerMenu">
        <a href="#" id="hamburger"><img src="img/btn_hamburguer.svg" alt="Men� principal" class="imgHamburgesa"></a>
      </div>
      <div class="headerLogo">
        <a href="index.html"><img src="img/logo.svg" id="imgLogo"></a>
      </div>
      <div class="headerUser">
        <div class="name"><strong>Participante</strong> GS HackChallenge <br> Administrador</div>
        <div class="pic" style="background-image: url('img/user.jpg');"></div>
        <div class="noti">7</div>
        <div class="user-menu">
          <a href="#"><img src="img/btn_desp_menu.svg" class="imgShowMenuUser"></a>
        </div>
        <div class="fecha">
			<b>24/Agosto/2019</b>
		</div>
      </div>

    </div>
    <div class="MenuUser">
      <div class="MenuUser1">
        <a href="login.html" class="selMenu">
          <div>Salir</div>
          <div><img src="img/ico5.svg" class="imgConfig"></div>
        </a>
      </div>
    </div>
    <div class="clear"></div>

    <div class="titulo">
    	<div class="ruta">
			<a href="index.html">P�gina Principal</a> /
			<a href="index.html">Inicio</a> 
		</div>
    	Inicio
    </div>

	<!-- Menu -->
    <div id="effect" class="ui-widget-content ui-corner-all">
      <div id="menuPrincipal">
        <div class="header-usuario">
          <div id="foto"><img src="img/logo.svg" class="imgLogo"></div>
          <div id="inf-usuario">Men� Principal<br></div>
        </div>
        <div id="buscador">
          <form id="miForm" name="miForm" action="" method="get" onsubmit="return valida(this)">
            <div class="w87"><input type="text" id="busca">
              <input type="submit" class="buscar" value=""></div>
          </form>
        </div>
       <div id="menu">
			  <ul class="l-navegacion nivel1">
					<li>
						<a><p>Productos</p><div class="flecha"></div></a>
						<ul class="nivel2"> 
							<li><a  href="index.html"><p>Tarjetas</p></a></li>
							<li>
								<a><p>Cuentas</p><div class="flecha"></div></a>
								<ul class="nivel3 fix1"> 
									<li><a  href="index.html"><p>Tarjeta de Cr�dito Oro</p></a></li>
									<li><a  href="index.html"><p>Tarjeta de Cr�dito Elektra</p></a></li>
									<li><a  href="index.html"><p>Tarjeta Azteca</p></a></li>
									<li><a  href="index.html"><p>Tarjeta de Cr�dito Cl�sica</p></a></li>
								</ul>
							</li>
							<li><a  href="index.html"><p>Inversi�n</p></a></li>
							<li><a  href="index.html"><p>Negocio</p></a></li>
						</ul>
					</li>
					<li><a href="index.html"><p>Servicios</p></a></li>
					
				</ul>
			</div>
      </div>
    </div>

    <!-- Contenido -->
    <div class="contHome">
    	<div class="divMenu">
			<a href="servicios-banco.jsp" class="menuH"><img src="img/iconos/ico1.svg"><br>Portal de<br> retiros</a>
			<a href="#" class="menuH"><img src="img/iconos/ico2.svg"><br>Portal<br>1</a>
			<a href="#" class="menuH"><img src="img/iconos/ico3.svg"><br>Portal<br>2</a>
			<a href="#" class="menuH"><img src="img/iconos/ico4.svg"><br>Portal<br>3</a>
		</div>
			
	</div>	<!-- Fin conSecc -->
	
	<!-- Footer -->
	<div class="footer">
		<div>Banco Azteca S.A. Instituci�n de Banco Multiple</div>
		<div>Derechos Reservados 2014 (T�rminos y Condiciones de uso del portal)</div>
	</div>
</div><!-- Fin page -->
<div class="sobresombra"></div>
</body>
</html>

<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/jquery.dropkick.js"></script><!--Select -->
<script type="text/javascript" src="js/content_height.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script src="js/jquery.simplemodal.js"></script>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/funciones.js"></script>
