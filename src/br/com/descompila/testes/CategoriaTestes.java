package br.com.descompila.testes;

import br.com.descompila.model.bean.Categoria;
import br.com.descompila.model.bean.dao.CategoriaDAO;

public class CategoriaTestes {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setDescription("Comida");
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.save(categoria);
    }
}
