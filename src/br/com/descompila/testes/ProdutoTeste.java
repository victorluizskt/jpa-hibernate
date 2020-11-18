package br.com.descompila.testes;

import br.com.descompila.model.bean.Produto;
import br.com.descompila.model.bean.dao.ProdutoDAO;

public class ProdutoTeste {
    public static void main(String[] args) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        for(Produto p: produtoDAO.findAll()){
            System.out.println(p);
        }
    }
}
