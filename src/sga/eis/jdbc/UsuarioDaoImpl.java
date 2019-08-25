package sga.eis.jdbc;

import sga.eis.dao.*;
import sga.eis.dto.*;
import sga.eis.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDaoImpl extends AbstractDAO implements UsuarioDao {
	protected java.sql.Connection userConn;
	protected final String SQL_SELECT = "SELECT id_usuario, id_persona, username, password FROM " + getTableName() + "";
	protected int maxRows;
	protected final String SQL_INSERT = "INSERT INTO " + getTableName()
			+ " ( id_usuario, id_persona, username, password ) VALUES ( ?, ?, ?, ? )";
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id_usuario = ?";
	protected static final int COLUMN_ID_USUARIO = 1;
	protected static final int COLUMN_ID_PERSONA = 2;
	protected static final int COLUMN_USERNAME = 3;
	protected static final int COLUMN_PASSWORD = 4;
	protected static final int NUMBER_OF_COLUMNS = 4;
	protected static final int PK_COLUMN_ID_USUARIO = 1;

	public UsuarioPk insert(Usuario dto) throws UsuarioDaoException {
		long t1 = System.currentTimeMillis();
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();

			stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			if (dto.getIdUsuario() != null) {
				stmt.setInt(index++, dto.getIdUsuario().intValue());
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}

			if (dto.getIdPersona() != null) {
				stmt.setInt(index++, dto.getIdPersona().intValue());
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}

			stmt.setString(index++, dto.getUsername());
			stmt.setString(index++, dto.getPassword());
			System.out.println("Executing " + SQL_INSERT + " with DTO: " + dto);
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println(rows + " rows affected (" + (t2 - t1) + " ms)");

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdUsuario(new Integer(rs.getInt(1)));
			}

			reset(dto);
			return dto.createPk();
		} catch (Exception _e) {
			_e.printStackTrace();
			throw new UsuarioDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public Usuario findByPrimaryKey(UsuarioPk pk) throws UsuarioDaoException {
		return findByPrimaryKey(pk.getIdUsuario());
	}

	public Usuario findByPrimaryKey(Integer idUsuario) throws UsuarioDaoException {
		Usuario ret[] = findByDynamicSelect(SQL_SELECT + " WHERE id_usuario = ?", new Object[] { idUsuario });
		return ret.length == 0 ? null : ret[0];
	}

	public Usuario[] findAll() throws UsuarioDaoException {
		return findByDynamicSelect(SQL_SELECT + " ORDER BY id_usuario", null);
	}

	public Usuario[] findByPersona(Integer idPersona) throws UsuarioDaoException {
		return findByDynamicSelect(SQL_SELECT + " WHERE id_persona = ?", new Object[] { idPersona });
	}

	public UsuarioDaoImpl() {
	}

	public UsuarioDaoImpl(final java.sql.Connection userConn) {
		this.userConn = userConn;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public String getTableName() {
		return "usuario";
	}

	protected Usuario fetchSingleResult(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Usuario dto = new Usuario();
			populateDto(dto, rs);
			return dto;
		} else {
			return null;
		}

	}

	protected Usuario[] fetchMultiResults(ResultSet rs) throws SQLException {
		Collection<Usuario> resultList = new ArrayList<Usuario>();
		while (rs.next()) {
			Usuario dto = new Usuario();
			populateDto(dto, rs);
			resultList.add(dto);
		}

		Usuario ret[] = new Usuario[resultList.size()];
		resultList.toArray(ret);
		return ret;
	}

	protected void populateDto(Usuario dto, ResultSet rs) throws SQLException {
		dto.setIdUsuario(new Integer(rs.getInt(COLUMN_ID_USUARIO)));
		dto.setIdPersona(new Integer(rs.getInt(COLUMN_ID_PERSONA)));
		dto.setUsername(rs.getString(COLUMN_USERNAME));
		dto.setPassword(rs.getString(COLUMN_PASSWORD));
	}

	protected void reset(Usuario dto) {
	}

	public Usuario[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsuarioDaoException {
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
			throw new UsuarioDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	public Usuario[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsuarioDaoException {
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
			throw new UsuarioDaoException("Exception: " + _e.getMessage(), _e);
		} finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}

		}

	}

	@Override
	public void update(UsuarioPk pk, Usuario dto) throws UsuarioDaoException {

	}

	@Override
	public void delete(UsuarioPk pk) throws UsuarioDaoException {

	}

}
