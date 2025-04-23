package br.edu.infnet.app.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.app.model.domain.Pagamento;

public class TestePagamento {
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
                
                System.out.println(p);
                System.out.println("---------------------------------------------------------------------------------------------");

                linha = leituraPagamentos.readLine();
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