package sga.eis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import sga.eis.dao.PersonaDao;
import sga.eis.dto.Persona;
import sga.eis.dto.PersonaPk;
import sga.eis.exceptions.PersonaDaoException;

public class PersonaDaoImpl extends AbstractDAO implements PersonaDao {
	private java.sql.Connection userConn;

	protected final String SQL_SELECT = "SELECT IdCliente, curp, nombre, primerapellido, segundoapellido, iden, noiden, nss, numero_telefono, nocuenta, noclabeinterbancaria FROM "
			+ getTableName() + "";

	protected int maxRows;

	protected final String SQL_INSERT = "INSERT INTO " + getTableName()
			+ " ( id_persona, nombre, apellido ) VALUES ( ?, ?, ? )";
	protected final String SQL_UPDATE = "UPDATE " + getTableName()
			+ " SET id_persona = ?, nombre = ?, apellido = ? WHERE idcliente = ?";
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE idcliente = ?";
	protected static final int COLUMN_ID_PERSONA = 1;
	//protected static final int COLUMN_CURP = 2;
	protected static final int COLUMN_NOMBRE = 2;
	protected static final int COLUMN_APELLIDO = 3;
	protected static final int NUMBER_OF_COLUMNS = 4;
	protected static final int PK_COLUMN_ID_PERSONA = 1;

	public PersonaPk insert(Persona dto) throws PersonaDaoException {
		long t1 = System.currentTimeMillis();
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();

			stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			if (dto.getIdPersona() != null) {
				stmt.setInt(index++, dto.getIdPersona().intValue());
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}

			stmt.setString(index++, dto.getNombre());
			stmt.setString(index++, dto.getApellido());
			System.out.println("Executing " + SQL_INSERT + " with DTO: " + dto);
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println(rows + " rows affected (" + (t2 - t1) + " ms)");

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdPersona(new Integer(rs.getInt(1)));
			}

			reset(dto);
			return dto.createPk();
		} catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public void update(PersonaPk pk, Persona dto) throws PersonaDaoException {
		long t1 = System.currentTimeMillis();
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();

			System.out.println("Executing " + SQL_UPDATE + " with DTO: " + dto);
			stmt = conn.prepareStatement(SQL_UPDATE);
			int index = 1;
			if (dto.getIdPersona() != null) {
				stmt.setInt(index++, dto.getIdPersona().intValue());
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}

			stmt.setString(index++, dto.getNombre());
			stmt.setString(index++, dto.getApellido());
			if (pk.getIdPersona() != null) {
				stmt.setInt(4, pk.getIdPersona().intValue());
			} else {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}

			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println(rows + " rows affected (" + (t2 - t1) + " ms)");
		} catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public void delete(PersonaPk pk) throws PersonaDaoException {
		long t1 = System.currentTimeMillis();
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();

			System.out.println("Executing " + SQL_DELETE + " with PK: " + pk);
			stmt = conn.prepareStatement(SQL_DELETE);
			if (pk.getIdPersona() != null) {
				stmt.setInt(1, pk.getIdPersona().intValue());
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}

			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println(rows + " rows affected (" + (t2 - t1) + " ms)");
		} catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public Persona findByPrimaryKey(PersonaPk pk) throws PersonaDaoException {
		return findByPrimaryKey(pk.getIdPersona());
	}

	public Persona findByPrimaryKey(Integer idPersona) throws PersonaDaoException {
		Persona ret[] = findByDynamicSelect(SQL_SELECT + " WHERE IdCliente = ?", new Object[] { idPersona });
		return ret.length == 0 ? null : ret[0];
	}

	public Persona[] findAll() throws PersonaDaoException {
		return findByDynamicSelect(SQL_SELECT + " ORDER BY IdCliente", null);
	}

	public PersonaDaoImpl() {
	}

	public PersonaDaoImpl(final java.sql.Connection userConn) {
		this.userConn = userConn;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public String getTableName() {
		return "td_persona";
	}

	protected Persona fetchSingleResult(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Persona dto = new Persona();
			populateDto(dto, rs);
			return dto;
		} else {
			return null;
		}

	}

	protected Persona[] fetchMultiResults(ResultSet rs) throws SQLException {
		Collection<Persona> resultList = new ArrayList<Persona>();
		while (rs.next()) {
			Persona dto = new Persona();
			populateDto(dto, rs);
			resultList.add(dto);
		}

		Persona ret[] = new Persona[resultList.size()];
		resultList.toArray(ret);
		return ret;
	}

	protected void populateDto(Persona dto, ResultSet rs) throws SQLException {
		dto.setIdPersona(new Integer(rs.getString(COLUMN_ID_PERSONA)));
		//dto.setCurp(rs.getString(COLUMN_CURP));
		dto.setNombre(rs.getString(COLUMN_NOMBRE));
		dto.setApellido(rs.getString(COLUMN_APELLIDO));
	}

	protected void reset(Persona dto) {
	}

	public Persona[] findByDynamicSelect(String sql, Object[] sqlParams) throws PersonaDaoException {
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();

			final String SQL = sql;

			System.out.println("Executing " + SQL);
			stmt = conn.prepareStatement(SQL);
			stmt.setMaxRows(maxRows);

			for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
				stmt.setObject(i + 1, sqlParams[i]);
			}

			rs = stmt.executeQuery();

			return fetchMultiResults(rs);
		} catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public Persona[] findByDynamicWhere(String sql, Object[] sqlParams) throws PersonaDaoException {
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();

			final String SQL = SQL_SELECT + " WHERE " + sql;

			System.out.println("Executing " + SQL);
			stmt = conn.prepareStatement(SQL);
			stmt.setMaxRows(maxRows);

			for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
				stmt.setObject(i + 1, sqlParams[i]);
			}

			rs = stmt.executeQuery();

			return fetchMultiResults(rs);
		} catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public java.sql.Connection getUserConn() {
		return userConn;
	}

	public void setUserConn(java.sql.Connection userConn) {
		this.userConn = userConn;
	}

}
