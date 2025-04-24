package br.edu.infnet.app.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.app.model.domain.Pagamento;

public class TestePagamento {
    private static Map<String, Pagamento> mapaPagamentos = new HashMap<String, Pagamento>();

    private static void registrarPagamento(Pagamento p){
        mapaPagamentos.put(p.pedido, p);
    }

    private static Collection<Pagamento> obterPagamentos(){
        return mapaPagamentos.values();
    }
    public static void main(String[] args) {
        try {
            FileReader arquivoPagamentos = new FileReader("CristyanResendeApp\\pagamento.csv");
            BufferedReader leituraPagamentos = new BufferedReader(arquivoPagamentos);

            String linha = leituraPagamentos.readLine();
            String[] campos = null;

            while(linha != null){
                campos = linha.split(",");
                
                Pagamento p = new Pagamento();
                p.pedido = campos[0];
                p.forma = campos[1];
                p.valor = Float.parseFloat(campos[2]);
                p.status = campos[3];
                
                registrarPagamento(p);
                linha = leituraPagamentos.readLine();
            }
            for(Pagamento p : obterPagamentos()){
                System.out.println(p);
                System.out.println("---------------------------------------------------------------------------------------------");
            }
            leituraPagamentos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de pagamentos não encontrado");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Imporssível abrir/fechar o arquivo");
            e.printStackTrace();
        }
    }
}