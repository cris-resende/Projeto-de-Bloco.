package br.edu.infnet.app.model.domain;

import java.util.List;

public class Produto {
    public String nomeProduto;
    public String categoria;
    public double preco;
    public int estoque;
    public List<Pedido> pedido;
    
    @Override
    public String toString() {
        return String.format("Produto: %s - Categoria: %s - Preço: %f - Estoque: %d", nomeProduto, categoria, preco, estoque);
    }
}