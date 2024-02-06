/**
 * 
 */


import java.util.List;


/**
 * @author Rafael da Silva Muniz
 *
 */
public interface IProdutoDAO {

	public Integer cadastrar(Produto produto) throws Exception;
	
	public Integer atualizar(Produto produto) throws Exception;
	
	public Produto buscar(String codigo) throws Exception;
	
	public List<Produto> buscarTodos() throws Exception;
	
	public Integer excluir(Produto produto) throws Exception;
}
