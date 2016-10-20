import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import  java.util.Scanner;
class Main
{
    private static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String dicionario;
        ArrayList<No> Nos = new ArrayList();
        dicionario = entrada.nextLine();
        char letra;
        int quantidade;
        
        //System.out.println(dicionario);
        
        
        dicionario = dicionario.replace("{", " ");   // remove abertura de chaves
        dicionario = dicionario.replace("}", "");   // remove fechamento de chaves
        
        //System.out.println(dicionario);
        
        String[] values = dicionario.split(",");    // divide o dicionario por vírgulas
        
        for (String value : values) // para cada letra e sua quantidade
        {
            letra = value.charAt(2);
            quantidade = Integer.valueOf(value.substring(6));
            
            No no = new No(letra, quantidade);  //cria um novo no
            //System.out.println("<--" + letra + "," + quantidade + "-->");
            
            Nos.add(no);
        }
        Nos.sort(new Comparator<No>()   // ordenando as letras de modo decrescente
        {
            @Override
            public int compare(No o1, No o2)
            {
                return (o1.quantidade > o2.quantidade)? 1 : 0;
            } 
        });
        for(No no : Nos)
        {
            //System.out.println(no.letra+","+no.quantidade);
        }
    }
    
    private static class FilaPrioridadeMinima
    {
        No[] nos; 
        int tamanho;
        public FilaPrioridadeMinima(int quantidade)
        {
            tamanho = 0;
            nos = new No[tamanho];
        }
        
        private int Pai(int i)
        {
            
        }
    }
    private static class No
    {
        private char letra;
        private int quantidade;
        
        public No(char letra, int quantidade)
        {
            this.letra = letra;
            this.quantidade = quantidade;
        }
    }
}
 