package br.edu.infnet.app.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DateFormatter;

import br.edu.infnet.app.model.domain.Pedido;

public class TestePedido {

    private static Map<String, Pedido> mapaPedidos = new HashMap<String, Pedido>();

    private static void incluirPedido(Pedido p){
        mapaPedidos.put(p.cliente,p);
    }

    private static Collection<Pedido> obterPedidos(){
        return mapaPedidos.values();
    }
    public static void main(String[] args) {
        try{
            FileReader arquivoPedidos = new FileReader("CristyanResendeApp\\pedidos.csv");
            BufferedReader leituraPedidos = new BufferedReader(arquivoPedidos);

            String linha = leituraPedidos.readLine();
            String[] campos = null;

            while(linha != null){
                campos = linha.split(",");

                Pedido p = new Pedido();
                p.cliente = campos[0];
                p.produto = campos[1];

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                p.data = LocalDate.parse(campos[2], formato);
                p.status = campos[3];

                incluirPedido(p);
                linha = leituraPedidos.readLine();
            }
            for (Pedido p : obterPedidos()){
                System.out.println(p);
                System.out.println("---------------------------------------------------------------------------------------------");
            }
            leituraPedidos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de pedidos não encontrado");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Imporssível abrir/fechar o arquivo");
            e.printStackTrace();
        }
    }
}