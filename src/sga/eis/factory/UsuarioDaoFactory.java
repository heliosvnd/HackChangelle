package sga.eis.factory;

import java.sql.Connection;
import sga.eis.dao.*;
import sga.eis.jdbc.*;

public class UsuarioDaoFactory {
	public static UsuarioDao create() {
		return new UsuarioDaoImpl();
	}

	public static UsuarioDao create(Connection conn) {
		return new UsuarioDaoImpl(conn);
	}

}
