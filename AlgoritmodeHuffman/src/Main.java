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
        
        
        dicionario = dicionario.replace("{", " ");   //remove abertura de chaves
        dicionario = dicionario.replace("}", "");   //remove fechamento de chaves
        
        //System.out.println(dicionario);
        
        String[] values = dicionario.split(",");    //divide o dicionario por vírgulas
        
        for (String value : values) //para cada letra e sua quantidade
        {
            letra = value.charAt(2);
            quantidade = Integer.valueOf(value.substring(6));
            
            No no = new No(letra, quantidade);  //cria um novo no
            //System.out.println("<--" + letra + "," + quantidade + "-->");
            
            Nos.add(no);
        }
        Nos.sort(new Comparator<No>()   //ordenando as letras de modo decrescente
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
            nos = new No[quantidade+1];
        }
        public void Inserir(No no)
        {
            tamanho++;
            nos[tamanho] = no;   //adiciona o no no fim do heap
            
            if(tamanho > 1)    //se nao for o no raiz
            {
                int i = tamanho;
                
                //aux.letra = nos[Pai(tamanho)].letra;
                //aux.quantidade = nos[Pai(tamanho)].quantidade;
                while(nos[Pai(i)].quantidade > nos[i].quantidade && i != 0) 
                {
                    //nos[Pai(tamanho)].letra = nos[i].letra;
                    //nos[Pai(tamanho)].quantidade = nos[i].quantidade;
                    No aux = nos[Pai(tamanho)];
                    nos[Pai(tamanho)] = nos[i];
                    nos[i] = aux;
                    i = Pai(i);
                }
            }
        }
        
        public void Show()
        {
            for(int i = 1 ; i <= tamanho ; i++)
            {
                
            }
        }
        private int Pai(int i)
        {
            return Math.floorDiv(i, 2);
            //return i >> 1;
        }
        private int Esq(int i)
        {
            return i * 2;
            //return i << 1;
        }
        private int Dir(int i)
        {
            return i * 2 + 1;
            //return i << 1 | 1;
        }
    }
    private static class No
    {
        private char letra;
        private int quantidade;
        
        public No()
        {
            
        }
        public No(char letra, int quantidade)
        {
            this.letra = letra;
            this.quantidade = quantidade;
        }
    }
}
 