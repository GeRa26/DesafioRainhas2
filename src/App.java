public class App {

        static int numerosolucoes = 0;
    
        public static void main(String[] args)   {
    
            int[] linhas = {0, 1, 2,3,4};
            combinaçãoValoresSemRepeticao(linhas, 5, 5, 0);		
            System.out.println("Total de soluções: "+numerosolucoes);
    
        }
    
        public static boolean checaRepeticao(int[] vetor)  {
            int valor = 0; 
            for (int i = 0; i < vetor.length;i++)  {
                valor = vetor[i];
                for (int j = i+1; j < vetor.length;j++)  {
                    if (vetor[j] == valor)  {
                        return true;
                    }
                }
            }
            return false;
        }
    
        public static void combinaçãoValoresSemRepeticao(int[] seq, int n, int k, int i) {
            int v;
            // Uma vez gerada a solução, testa se é válida. Se for, imprime.
            if (i == k) {
                if (!checaRepeticao(seq) )  {
                    if(SolucaoValida(seq, n)==1)
                        ImprimeSolucao(seq, n);
                }
            }
            else
                for (v = 0; v < n; v++) {
                    seq[i] = v;
                    combinaçãoValoresSemRepeticao(seq, n, k, i+1);
                }
        }
    
        // a partir de um vetor com uma solução do problema com n rainhas
        // imprime o tabuleiro com essa solução.
        public static void ImprimeSolucao(int linhas[], int nrainhas){
            char[][] tabuleiro= new char[nrainhas][nrainhas];
            int i,j, x,y;
            numerosolucoes++;
    
            System.out.printf("******** SOL: %d ********\n",numerosolucoes);
    
            // preenche a matriz com um tabuleiro vazio, só com pontos.
            for(i = 0; i < nrainhas; i++)
                for(j = 0; j < nrainhas; j++)
                    tabuleiro[i][j] = '.';
            // coloca as rainhas (letra R) no tabuleiro a partir do vetor
            for(i = 0; i < nrainhas; i++){
                x = i;
                y = linhas[i];
                tabuleiro[y][x] = 'R';
            }
            // imprime o tabuleiro completo, já com as rainhas nele.
            for(i = 0; i < nrainhas; i++){
                for(j = 0; j < nrainhas; j++){
                    System.out.printf(" %c ",tabuleiro[i][j]);
                }    
                System.out.printf("\n");
            }
        }
    
        // a função abaixo testa a diagonal superior direita
        // e a diagonal superior esquerda de cada rainha.
        // se encontrar uma rainha, retorna 0 (solução inválida).
        // se testar todas as rainhas sem problema, solução válida -> 1
        public static int SolucaoValida(int linhas[], int nrainhas){
            int i;
            int x,y;
            int xx,yy;
            for(i = 0; i < nrainhas; i++){
                x = i; // rainha que será testada (coluna)
                y = linhas[i]; // linha da rainha (linha 0 topo do tabuleiro)
                xx = x;  		// xx = coluna da rainha
                yy = y;  		// yy = linha da rainha
                // testa diagonal superior a direita da rainha
                while(true){
                    xx += 1;
                    yy -= 1;
                    // se saiu do limite do tabuleiro encerra.
                    if(xx > (nrainhas-1) || yy < 0) break;
                    // se achou uma rainha, solução inválida.
                    if(yy == linhas[xx]) 
                        return 0;
                }
                // reseta as coordenadas, para testar a diagonal superior esquerda
                xx = x;
                yy = y;
                // testa diagonal superior a esquerda da rainha
                while(true)  {
                    xx -= 1;
                    yy -= 1;
                    if(xx < 0 || yy < 0) break;
                    // se achou rainha, solução inválida
                    if(yy == linhas[xx]) 
                        return 0;
                }
            }
            return 1;           // não achou rainha, solução válida!
        }
    
    
    
    
    }
    


