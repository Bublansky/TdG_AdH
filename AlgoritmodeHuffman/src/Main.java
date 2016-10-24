import java.util.ArrayList;
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
            Nos.add(no);    //inserindo o no na lista de nos
        }
        //Nos.sort((No o1, No o2) -> (o1.quantidade > o2.quantidade)? 1 : 0); //ordenando as letras de modo decrescente
        FilaPrioridadeMinima fila = new FilaPrioridadeMinima(Nos.size());   //criacao da fila de prioridade 
        Nos.stream().forEach((no) ->    //inserir cada no na fila
        {
            fila.Inserir(no);   //inserindo o no
        }); //depois de inserir cada no na fila de prioridades
        while(fila.getQuantidade() > 1)
        {
            No no1 = fila.ExtrairMinimo();  //retira o primeiro menor
            No no2 = fila.ExtrairMinimo();  //retira o segundo menor
            
        }
    }
    private static class FilaPrioridadeMinima
    {
        private No[] nos; 
        private int tamanho;
        public FilaPrioridadeMinima(int quantidade)
        {
            tamanho = 0;
            nos = new No[quantidade+1];
        }
        public int getQuantidade()
        {
            return this.tamanho;
        }
        public No ExtrairMinimo()
        {
            No menor = nos[1];
            nos[1] = nos[tamanho];  //substitui a raiz pelo ultimo elemento
            int i = 1;
            tamanho--;
            while(nos[i].quantidade > nos[Esq(i)].quantidade || 
                    nos[i].quantidade > nos[Dir(i)].quantidade) //enquanto o pai for maior que os filhos
            {
                if(nos[Esq(i)].quantidade < nos[Dir(i)].quantidade)    //se o filho da esquerda for o menor
                {
                    No aux = nos[Esq(i)];
                    nos[Esq(i)] = nos[i];   //troca o filho da esquerda pelo pai
                    nos[i] = aux;   //troca o pai pelo filho da esquerda
                    i = Esq(i);
                }
                else    //se o da esquerda nao for o menor
                {
                    No aux = nos[Dir(i)];
                    nos[Dir(i)] = nos[i];   //troca o filho da direita pelo pai
                    nos[i] = aux;   //troca o pai pelo filho da direita
                    i = Dir(i);
                }
            }
            return menor;
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
        private int quantidade, soma = 0;
        private No esq, dir;
        
        
        public void inserirEsq(No noEsq)
        {
            this.esq = noEsq;
        }
        public void inserirDir(No noDir)
        {
            this.dir = noDir;
        }
        public No()
        {
            iniciarFilhos();
        }
        public No(char letra, int quantidade)
        {
            this.letra = letra;
            this.quantidade = quantidade;
            iniciarFilhos();
        }
        private void iniciarFilhos()
        {
            esq = null;
            dir = null;
        }
    }
}
 