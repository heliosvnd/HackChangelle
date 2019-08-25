package sga.eis.dao;

import sga.eis.dto.*;
import sga.eis.exceptions.*;

public interface UsuarioDao {

	public UsuarioPk insert(Usuario dto) throws UsuarioDaoException;

	public void update(UsuarioPk pk, Usuario dto) throws UsuarioDaoException;

	public void delete(UsuarioPk pk) throws UsuarioDaoException;

	public Usuario findByPrimaryKey(UsuarioPk pk) throws UsuarioDaoException;

	public Usuario findByPrimaryKey(Integer idUsuario) throws UsuarioDaoException;

	public Usuario[] findAll() throws UsuarioDaoException;

	public Usuario[] findByPersona(Integer idPersona) throws UsuarioDaoException;

	public void setMaxRows(int maxRows);

	public int getMaxRows();

	public Usuario[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsuarioDaoException;

	public Usuario[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsuarioDaoException;

}
