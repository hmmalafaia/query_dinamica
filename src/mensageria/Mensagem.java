/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensageria;

/**
 *
 * @author henrique
 */
public class Mensagem {
    private final String msg_ajuda = "Instruções:"
            + "\n1) Em \"Comando\" digitar o comando desejado inserindo o caracter de interrogação como coringa."
            + "\n2) Em \"Caminho do arquivo\" selecionar o arquivo que possui os dados separados por ponto-vírgula (;) para substituição de cada caracter coringa do comando."
            + "\n3) Clicar no botão \"Executar\""
            + "\nExemplo"
            + "\nComando: INSERT INTO TABLE VALUES ('?',?);"
            + "\nCaminho do arquivo: C:\\temp\\entrada.txt"
            + "\nConteúdo do arquivo \"entrada.txt\""
            + "\nABC;123"
            + "\nXYZ;999"
            + "\nResultado:"
            + "\nINSERT INTO TABLE VALUES ('ABC',123);"
            + "\nINSERT INTO TABLE VALUES ('XYZ',999);";
    public String getMsg_ajuda() {
        return msg_ajuda;
    }
    
    private final String msg_contato = "hmmalafaia@gmail.com";

    public String getMsg_contato() {
        return msg_contato;
    }
    
}