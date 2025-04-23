package br.edu.infnet.app.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.app.model.domain.Usuario;

public class TesteUsuario {

    private static Map<String, Usuario> mapaUsers = new HashMap<String, Usuario>();

    private static void incluirUser(Usuario u){
        mapaUsers.put(u.email, u);
    }

    private static Collection<Usuario> obterUsers(){
        return mapaUsers.values();
    }

    public static void main(String[] args) {
        try{
            FileReader arquivo = new FileReader("CristyanResendeApp\\usuarios.csv");
            BufferedReader leitura = new BufferedReader(arquivo);

            String linha = leitura.readLine();
            String[] campos = null;

            while(linha != null){
                campos = linha.split(",");

                Usuario u = new Usuario();
                u.nome = campos[0];
                u.email = campos[1];
                u.tipo = campos[3];
                
                incluirUser(u);
                linha = leitura.readLine();

            }
            for(Usuario u : obterUsers()){
                System.out.println(u);
                System.out.println("-----------------------------------------------------------------");
            }
            leitura.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("Imporssível abrir/fechar o arquivo");
            e.printStackTrace();
        }
    }
}