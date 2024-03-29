<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
          <b>24/Agosto/2019</b><br>
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
        <a href="index.html">Portal de servicios</a>
      </div>
      Servicios 
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


    <div ng-show="isSet(1)">
      <div class="contHome">
      	<div class="blanco">
         	<div class="w80">
				<div class="tCenter">Identifica a tu cliente deslizando su <strong>Tarjeta Azteca,</strong> tecleando su <strong>CURP</strong> o su <strong>NSS</strong></div>
			  <div class="divGrow">
				<div class=" w60">
				  <div class="divGrow">
					<div class="col2 w60"><input type="text" placeholder="N�mero de Tarjeta Azteca"></div>
					<div class="col2 w30"><input type="text" placeholder="CVV"></div>
					<div class="col2 w60"><input type="text" placeholder="Monto a retirar"></div>
				  </div>
				</div>
				<div class=" w30"><a href="#" class="btnA">Deslizar tarjeta</a> </div>
				</div>
		  	</div>
          </div>

			<div class="btnCenter">
			  <a href="#" class="btnA btnG">Limpiar</a>
			  <a href="" class="btnA modalAviso_view" ng-click="setTab(2)">Siguiente</a>
			</div>
		</div>
    </div>
	
   <div ng-show="isSet(2)">
      <div class="contSecc">
			<div class="divMenuInfo">
    			<div><img src="img/icoUsuario.svg"> Cliente   GS HackChallenge </div>
    			<div>CURP:<span class="txtV"> CURP000000XXXXXXXX</span></div>
    			<div>NSS:<span class="txtV"> 1234567890</span></div>
  		  	</div>
       		 <div class="contHome">
       		 		<div class="titSec">Opciones frecuentes</div>
				  <div class="divMenu1">
					<a href="${pageContext.request.contextPath}/ServletControlador?accion=generaComprobanteDigital" class="menuH2">Generar  comprobante digital <br> <img src="img/comprobantedigital.jpg" class="imgShowMenuUser"></a>
					<a href="#" class="menuH2">  Enviar comprobante por  Whatsapp<br><img src="img/whatsapp.jpg" class="imgShowMenuUser"> </a>
					<a href="#" class="menuH2">Enviar  comprobante por  Mail <br><img src="img/mail.jpg" class="imgShowMenuUser"></a>
					<a href="#" class="menuH2">Imprimir Comprobante <br><br><img src="img/Impresora.jpg" class="imgShowMenuUser"></a>
					<a href="#" class="menuH2">Otro </a>
				  </div>
			  </div>
		</div>
    </div>
    
    

	<!-- DIV linea Afore Azteca -->
    <div class="lineaAfore">
      <table class="tblLineaAfore">
        <tr>
          <td><img src="img/icoTel.svg" alt=""></td>
          <td>
            <span>L�nea Azteca</span> <br>
            <span>01 800 040 7777</span> <br> <span>55 54 47 88 10</span> <br>
            <span>Interior de la Rep�blica y �rea Metropolitana</span>
          </td>
        </tr>
      </table>
    </div>

    <!-- Footer -->
    <div class="footer">
      <div>Banco Azteca S.A. Instituci�n de Banco Multiple</div>
      <div>Derechos Reservados 2018 (T�rminos y Condiciones de uso del portal)</div>
    </div>
  </div><!-- Fin page -->
  </div><!-- Fin page -->
<div class="sobresombra"></div>
</body>
</html>
  <!-- Modales -->

  <div id="modalAviso" class="modal">
    <div class="cuadroPrueba cuadroM">
      <a href="#" class="simplemodal-close btnCerrar"><img src="img/icoCerrar.svg"></a>
      <div class="titModal">Aviso urgente</div>
      <div class="contModal">
        <strong>�Informaci�n importante!</strong>
        <br><br>
        La innovaci�n y la creatividad son parte esencial en la construcci�n de un M�xico mejor,  asi que <strong>Agradecempos tu participaci�n </strong> y te deseamos la mejor de las suertes
        <br><br>
        <span>1er  #GSHackChallenge </span>
      </div>
      <div class="btnCenter">
        <a href="#" class="btnA simplemodal-close">Continuar</a>
      </div>
    </div>
  </div>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/jquery.dropkick.js"></script>
<!--Select -->
<script type="text/javascript" src="js/content_height.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script src="js/jquery.simplemodal.js"></script>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/funciones.js"></script>
<script src="js/jquery.simplemodal.js"></script>


<!-- Script Modal -->

<script type="text/javascript">

      $('#modalAviso').modal('show');

</script>
