package sga.eis.dao;

import sga.eis.dto.*;
import sga.eis.exceptions.*;
import java.sql.Connection;

public interface PersonaDao {
	public PersonaPk insert(Persona dto) throws PersonaDaoException;

	public void update(PersonaPk pk, Persona dto) throws PersonaDaoException;

	public void delete(PersonaPk pk) throws PersonaDaoException;

	public Persona findByPrimaryKey(PersonaPk pk) throws PersonaDaoException;

	public Persona findByPrimaryKey(Integer idPersona) throws PersonaDaoException;

	public Persona[] findAll() throws PersonaDaoException;

	public void setMaxRows(int maxRows);

	public int getMaxRows();

	public Persona[] findByDynamicSelect(String sql, Object[] sqlParams) throws PersonaDaoException;

	public Persona[] findByDynamicWhere(String sql, Object[] sqlParams) throws PersonaDaoException;

	public Connection getUserConn();

	public void setUserConn(Connection userConn);
}
