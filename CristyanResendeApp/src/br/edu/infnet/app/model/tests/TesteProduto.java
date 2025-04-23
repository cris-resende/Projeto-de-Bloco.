package br.edu.infnet.app.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.app.model.domain.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        try {
            FileReader arquivoProduto = new FileReader("CristyanResendeApp\\produtos.csv");
            BufferedReader leituraProduto = new BufferedReader(arquivoProduto);

            String linhaProduto = leituraProduto.readLine();
            String[] Produtos = null;

            while (linhaProduto != null) {
                Produtos = linhaProduto.split(",");
                
                Produto p = new Produto();
                p.nomeProduto = Produtos[0];
                p.categoria = Produtos[1];
                p.preco = Float.valueOf(Produtos[2]);
                p.estoque = Integer.parseInt(Produtos[3]);
                
                System.out.println(p);
                System.out.println("---------------------------------------------------------------------------------------------------");

                linhaProduto = leituraProduto.readLine();
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