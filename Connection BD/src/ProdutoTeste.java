/**
 *
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;


/*import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;/*


/**
 * @author Rafael da Silva Muniz
 *
 */
public class ProdutoTeste {


    private IProdutoDAO ProdutoDAO;


    @Test
    public void cadastrarTeste() throws Exception {
        ProdutoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setId(30L);
        produto.setCodigo("45");
        produto.setDescricao("Contra Filé");
        produto.setQuantidade(3);
        produto.setValorUnitario(35.78);
        produto.setValorTotal(107.34);

        Integer countCad = ProdutoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = ProdutoDAO.buscar("45");
        assertNotNull(produtoBD);
        //assertEquals(produto.getId(), produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
        assertEquals(produto.getValorUnitario(), produtoBD.getValorUnitario());
        assertEquals(produto.getValorTotal(), produtoBD.getValorTotal());

        //Integer countDel = ProdutoDAO.excluir(produtoBD);
        //assertTrue(countDel == 1);
    }


   @Test
    public void excluirTest() throws Exception {
        ProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("45");
       // assertTrue(countCad == 1);

        Produto produtoBD = ProdutoDAO.buscar("45");
        assertNotNull(produtoBD);

        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        //assertEquals(cliente.getNome(), clienteBD.getNome());

       Integer countDel = ProdutoDAO.excluir(produto);
        //assertTrue(countDel == 1);
    }

    @Test
    public void buscaTest() throws Exception {
        ProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("45");
        // assertTrue(countCad == 1);

        Produto produtoBD = ProdutoDAO.buscar("45");
        assertNotNull(produtoBD);

        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        //assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countBus;
                ProdutoDAO.buscar(String.valueOf(produtoBD));
        //assertTrue(countDel == 1);
    }

    @Test
    public void atualizarTest() throws Exception {
        ProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setId((long) 31L);
        produto.setCodigo("13");
        produto.setDescricao("Salmão");
        produto.setQuantidade(3);
        produto.setValorUnitario(35.78);
        produto.setValorTotal(107.34);

        Integer countAtu = ProdutoDAO.atualizar(produto);
        assertTrue(countAtu == 1);

        Produto produtoBD = ProdutoDAO.buscar("13");
        //assertNotNull(produtoBD);
        assertEquals(produto.getId(), produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
        assertEquals(produto.getValorUnitario(), produtoBD.getValorUnitario());
        assertEquals(produto.getValorTotal(), produtoBD.getValorTotal());

        //assertEquals(produto.getId(), produtoBD.getId());
        //assertEquals(cliente.getNome(), clienteBD.getNome());

        //Integer countAtu = ProdutoDAO.atualizar(produtoBD);
        //assertTrue(countDel == 1);
    }
}

    
