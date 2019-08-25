package sga.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sga.eis.dto.Operacion;
import sga.eis.dto.Persona;
import sga.eis.dto.Sucursal;
import sga.eis.dto.Ticket;
import sga.eis.dto.Operacion.Tipo;
import sga.services.PersonaService;
import sga.services.impl.PersonaServiceImpl;

@WebServlet(name = "ServletControlador", urlPatterns = { "/ServletControlador" })
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		if ("generaComprobanteDigital".equals(accion)) {
			this.generaComprobanteDigital(request, response);
		} else if ("validarUsuario".equals(accion)) {
			this.enviaWhastapp(request, response);
		} else if ("agregarPersona".equals(accion)) {
			this.enviaCorreo(request, response);
		} else if ("editarPersona".equals(accion)) {
			this.ImprimeComprobante(request, response);
		} else if ("eliminarPersona".equals(accion)) {
			this.enviaMSM(request, response);
		} else if ("salir".equals(accion)) {
			this.salir(request, response);
		} else {
			this.accionPorDefault(request, response);
		}

	}

	private void enviaMSM(HttpServletRequest request, HttpServletResponse response) {

	}

	private void ImprimeComprobante(HttpServletRequest request, HttpServletResponse response) {

	}

	private void enviaCorreo(HttpServletRequest request, HttpServletResponse response) {

	}

	private void enviaWhastapp(HttpServletRequest request, HttpServletResponse response) {

	}

	private void generaComprobanteDigital(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//this.listarPersonas(request, response);
		String mensaje = "Se genera Reporte";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("ticket.jsp").forward(request, response);
	}

	private boolean listarPersonas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PersonaService personaService = PersonaServiceImpl.getInstance();
		List<Persona> personas = personaService.getAllPersonas();
		
		for (Persona persona : personas) {
			if (persona.getCurp().equals("CURPXXXXXXXXX1")) {
				return true;
			}
		}
		return false;
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	private void accionPorDefault(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "Acci&oacute;n no proporcionada o desconocida";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
