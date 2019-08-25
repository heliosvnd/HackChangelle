package sga.eis.factory;

import java.sql.Connection;
import sga.eis.dao.*;
import sga.eis.jdbc.*;

public class PersonaDaoFactory {
	public static PersonaDao create() {
		return new PersonaDaoImpl();
	}

	public static PersonaDao create(Connection conn) {
		return new PersonaDaoImpl(conn);
	}

}
