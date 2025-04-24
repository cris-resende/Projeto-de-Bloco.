package br.edu.infnet.app.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.app.model.domain.Produto;

public class TesteProduto {

    private static Map<Integer, Produto> mapaProdutos = new HashMap<Integer, Produto>();

    private static void incluirProduto(Produto p){
        mapaProdutos.put(p.codigo, p);
    }

    private static Collection<Produto> obterProdutos(){
        return mapaProdutos.values();
    }
    public static void main(String[] args) {
        try {
            FileReader arquivoProduto = new FileReader("CristyanResendeApp\\produtos.csv");
            BufferedReader leituraProduto = new BufferedReader(arquivoProduto);

            String linhaProduto = leituraProduto.readLine();
            String[] Produtos = null;

            while (linhaProduto != null) {
                Produtos = linhaProduto.split(",");
                
                Produto p = new Produto();
                p.codigo = Integer.parseInt(Produtos[0]);
                p.nomeProduto = Produtos[1];
                p.categoria = Produtos[2];
                p.preco = Float.valueOf(Produtos[3]);
                p.estoque = Integer.parseInt(Produtos[4]);
                
                incluirProduto(p);
                linhaProduto = leituraProduto.readLine();
            }

            for(Produto p : obterProdutos()){
                System.out.println(p);
                System.out.println("---------------------------------------------------------------------------------------------");
            }
            leituraProduto.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de produtos não encontrado");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Imporssível abrir/fechar o arquivo");
            e.printStackTrace();
        }
    }
}