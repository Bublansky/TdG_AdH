import java.util.ArrayList;
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
        
        
        dicionario = dicionario.replace("{", "");   // remove abertura de chaves
        dicionario = dicionario.replace("}", "");   // remove fechamento de chaves
        //System.out.println(dicionario);
        
        String[] values = dicionario.split(",");    // divide o dicionario por vírgulas
        
        for (String value : values) // para cada letra e sua quantidade
        {
            letra = 
            No no = new No();
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
    
    private static class Grafo
    {
        private int adj[][];
        private int vertices = 0;
        private int distancia[];

        public Grafo(int quantidade)
        {
            vertices = quantidade;
            adj = new int [quantidade][quantidade];
            distancia = new int[quantidade];
        }
        public int getAresta(int origem, int destino)
        {
            return adj[origem][destino];
        }
        public void AddAresta(int linha, int coluna, int value)
        {
            adj[linha][coluna] = value;
        }
        public void BellmanFord(int origem)
        {
            int v, i, u, peso;
            //passo 1:
            for(v = 0 ; v < vertices ; v++)
            {
                distancia[v] = Integer.MAX_VALUE;
            }
            distancia[origem] = 0;
            //passo 2:
            for(i = 0 ; i < vertices - 1; i++)
            {
                for(u = 0 ; u < vertices ; u++)
                {
                    for(v = 0 ; v < vertices ; v++)
                    {
                        peso = getAresta(u, v);
                        if(peso != 0)
                        {    
                            if(distancia[u] != Integer.MAX_VALUE)
                            {
                                if(distancia[u] + peso < distancia[v])
                                {
                                    distancia[v] = distancia[u] + peso;
                                }
                            }
                        }
                    }
                }
            }
            //passo 3:
            for(u = 0 ; u < vertices ; u++)
            {
                for(v = 0 ; v < vertices ; v++)
                {
                    if(distancia[u] != Integer.MAX_VALUE)
                    {
                        peso = getAresta(u, v);
                        //se ha uma aresta uv
                        if(peso != 0)
                        {
                            if(distancia[u] + peso < distancia[v])
                            {
                                System.out.print("ciclo negativo");
                                return;
                            }
                        }
                    }
                }
            }
            for(i = 0 ; i < vertices ; i++)
            {
                if(distancia[i] == Integer.MAX_VALUE)
                {
                    System.out.print("i ");
                }
                else
                {
                    System.out.print(distancia[i] + " ");
                }
            }
        }
    }
}
 