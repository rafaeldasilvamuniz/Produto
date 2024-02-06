/**
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rafael da Silva Muniz
 *
 */
public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
		try {
			//connection = ConnectionFactory.getConnection();
			connection = JDBCConnection.getConnection();
			String sql = getSqlInsert();
			stm = connection.prepareStatement(sql);
			adicionarParametrosInsert(stm, produto);
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}


	@Override
	public Integer atualizar(Produto produto) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
		try {
			//connection = ConnectionFactory.getConnection();
			connection = JDBCConnection.getConnection();
			String sql = getSqlUpdate();
			stm = connection.prepareStatement(sql);
			adicionarParametrosUpdate(stm, produto);
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	@Override
	public Produto buscar(String codigo) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
    	ResultSet rs = null;
    	Produto produto = null;
		try {
			//connection = ConnectionFactory.getConnection();
			connection = JDBCConnection.getConnection();
			String sql = getSqlSelect();
			stm = connection.prepareStatement(sql);
			adicionarParametrosSelect(stm, codigo);
			rs = stm.executeQuery();
			
		    if (rs.next()) {
		    	produto = new Produto();
		    	Long id = rs.getLong("ID");
		    	String cd = rs.getString("CODIGO");
				String desc = rs.getString("DESCRICAO");
				Integer qtd = rs.getInt("QUANTIDADE");
                Double vu = rs.getDouble("VALORUNITARIO");
				Double vt = rs.getDouble("VALORTOTAL");
		    	produto.setId(id);
		    	produto.setCodigo(cd);
				produto.setDescricao(desc);
				produto.setQuantidade(qtd);
				produto.setValorUnitario(vu);
				produto.setValorTotal(vt);
		    }
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, rs);
		}
		return produto;
	}

	@Override
	public Integer excluir(Produto produto) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
		try {
			//connection = ConnectionFactory.getConnection();
			connection = JDBCConnection.getConnection();
			String sql = getSqlDelete();
			stm = connection.prepareStatement(sql);
			adicionarParametrosDelete(stm, produto);
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}
	
	@Override
	public List<Produto> buscarTodos() throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
    	ResultSet rs = null;
    	List<Produto> list = new ArrayList<>();
    	Produto produto = null;
		try {
			//connection = ConnectionFactory.getConnection();
			connection = JDBCConnection.getConnection();
			String sql = getSqlSelectAll();
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			
		    while (rs.next()) {
				produto = new Produto();
				Long id = rs.getLong("ID");
				String cd = rs.getString("CODIGO");
				String desc = rs.getString("DESCRICAO");
				Integer qtd = rs.getInt("QUANTIDADE");
				Double vu = rs.getDouble("VALORUNITARIO");
				Double vt = rs.getDouble("VALORTOTAL");
				produto.setId(id);
				produto.setCodigo(cd);
				produto.setDescricao(desc);
				produto.setQuantidade(qtd);
				produto.setValorUnitario(vu);
				produto.setValorTotal(vt);
		    }
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, rs);
		}
		return list;
	}
	
	private String getSqlInsert() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PRODUTO (ID, CODIGO, DESCRICAO, QUANTIDADE, VALORUNITARIO, VALORTOTAL) ");
		sb.append("VALUES (nextval('SQ_PRODUTO'),?,?,?,?,?)");
		return sb.toString();
	}
	
	private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
		stm.setString(1, produto.getCodigo());
		stm.setString(2, produto.getDescricao());
		stm.setInt(3,produto.getQuantidade());
		stm.setDouble(4,produto.getValorUnitario());
		stm.setDouble(5,produto.getValorTotal());
	}
	
	private String getSqlUpdate() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PRODUTO ");
		sb.append("SET CODIGO = ?, DESCRICAO = ? , QUANTIDADE = ?, VALORUNITARIO = ?, VALORTOTAL = ?");
		sb.append("WHERE ID = ?");
		return sb.toString();
	}
	
	private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {

		stm.setString(1, produto.getCodigo());
		stm.setString(2, produto.getDescricao());
		stm.setInt(3, produto.getQuantidade());
		stm.setDouble(4, produto.getValorUnitario());
		stm.setDouble(5, produto.getValorTotal());
		stm.setLong(6, produto.getId());
	}
	
	private String getSqlDelete() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM PRODUTO");
		sb.append("WHERE CODIGO = ?");
		return sb.toString();
	}
	
	private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
		stm.setString(1, produto.getCodigo());
	}
	
	private String getSqlSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM PRODUTO ");
		sb.append("WHERE CODIGO = ?");
		return sb.toString();
	}
	
	private void adicionarParametrosSelect(PreparedStatement stm, String produto) throws SQLException {
		stm.setString(1, produto);
	}
	
	private String getSqlSelectAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM PRODUTO");
		return sb.toString();
	}
	
	private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
