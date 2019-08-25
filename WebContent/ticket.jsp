<%@page import="sga.eis.dto.Ticket"%>
<%@page import="sga.eis.dto.Sucursal"%>
<%@page import="sga.eis.dto.Persona"%>
<%@page import="sga.eis.dto.Operacion.Tipo"%>
<%@page import="java.util.Date"%>
<%@page import="sga.eis.dto.Operacion"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="com.sun.corba.se.spi.orbutil.fsm.Input"%>
<%@ page language="java" contentType="application/pdf; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="net.sf.*"%>
<%@ page import="java.io.*"%>

<%Operacion operacion = new Operacion("50638098", "5515609", new Date(), 1000.0, Tipo.RETIRO); %>
<%Persona persona= new Persona("primerApellido", "segundoApellido", "nombre","CREDENCIAL_DE_ELECTOR","0123456789","01850111954904", "127180001119549047");%>
<%Sucursal sucursal= new Sucursal("GUSTAVO A MADERO, CUIDAD DE MEXICO", 2752L, "MEGA CUAUTEPEC","WS_CAJERO_I", new Date());%>
<%Ticket tramite= new Ticket(sucursal, persona, operacion); %>
try {

	String jrxmlFile = session.getServletContext().getRealPath("ticket.jrxml");
	InputStream input = new FileInputStream(new File(jrxmlFile));
	
	if(tramite.getCliente()!=null) {
		String app,apm;
		app = tramite.getCliente().getPrimerApellido()!=null?tramite.getCliente().getPrimerApellido():"";
		apm = tramite.getCliente().getSegundoApellido()!=null?tramite.getCliente().getSegundoApellido():"";
		parameters.put("Nombre", app+" "+apm+" "+tramite.getCliente().getNombre());
	}
	parameters.put("Escudo", escudo);
	parameters.put("Tickect", tramite);

	
	JasperReport jasperReport = JasperCompileManager.compileReport(input);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters);

	JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
	
	response.getOutputStream().flush();
	response.getOutputStream().close();
	
}catch
	(Exception e){

}

%>
