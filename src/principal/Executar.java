package principal;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author henrique
 */
public class Executar {
    public Executar(String comando,String caminho) throws IOException, InterruptedException {
        String sql_teamplate = comando;
        String sql_teamplate_original = sql_teamplate;
        String saida_txt = "output.txt";
        InputStream entrada_txt = null;
        try {
            entrada_txt = new FileInputStream(caminho);
        } catch (FileNotFoundException ex) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage() + "\nDigite o caminho completo do arquivo \nExemplo: C:\\temp\\arquivo.csv");
        }
        Scanner entrada = new Scanner(entrada_txt);
        FileWriter arquivo = null;
        PrintWriter escreveArquivo = null;
        try{
        arquivo = new FileWriter(saida_txt);
        escreveArquivo = new PrintWriter(arquivo);
        }catch(IOException ex){
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage());
        }
        while(entrada.hasNext()){
            String input_temp = entrada.nextLine();
            if (input_temp.isEmpty()) continue;
            String[] input_temp_pedacos = input_temp.split(";");
            for (String input_temp_pedaco : input_temp_pedacos) {
                sql_teamplate = sql_teamplate.replaceFirst("\\?", input_temp_pedaco);
            }
            escreveArquivo.println(sql_teamplate);
            sql_teamplate = sql_teamplate_original;
        }arquivo.close();
        //Runtime.getRuntime().exec("notepad output.txt");
        File file = new File(saida_txt);
        Desktop.getDesktop().open(file);
    }
}
