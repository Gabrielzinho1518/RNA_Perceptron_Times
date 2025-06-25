package pacote;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Perceptron {

    public List<Ponto> amostras;
    public List<Integer> saidas;
    public double taxa_aprendizado;
    public int geracoes;
    public int limiar;
    public int numeroAmostras;
    public int numeroAtributos;

    public double[] pesos;

        public Perceptron(List<Ponto> amostras, List<Integer> saidas, double taxa_aprendizado,  int geracoes, int limiar) {
            
            this.amostras = amostras;
            this.saidas = saidas;
            this.taxa_aprendizado = taxa_aprendizado;
            this.geracoes = geracoes;
            this.limiar = limiar;
            this.numeroAmostras = amostras.size();
            this.pesos = new double[3]; //tamanho deste vetor peso vai ser igual a quantidade de atributos + um valor par limiar
        }

        private int funcaoAtivacaoSignal(double soma)
        {
            if (soma >= 0) return 1;
            return -1;
        }

        public void treinar()
        {
            // Inserir o valor do limiar na posição limiar de cada ponto de cada amostra da lista "amostras.get"
            // Ex.: [[0.72, 0.82], ...] vira [[1, 0.72, 0.82], ...]
            for (int i = 0; i < this.amostras.size(); i++)
            {
            	amostras.get(i).limiar = this.limiar;

            }

            // Gerar valores randômicos entre 0 e 1 (pesos) conforme o número de atributos
            // a lista de pesos tem tamanho da quantidade de atributos de uma amostra
            //pesos = [1.0,0.4,0.6], por exemplo

            Random gerador = new Random();
            pesos[0] = limiar;
            pesos[1] = gerador.nextDouble(); //para o peso da entrada x
            pesos[2] = gerador.nextDouble(); //para o peso da entrada y

            int conta = 0;
            boolean aprendeu;
            double soma;
            int saida_gerada;

            while (true)
            {
                aprendeu = true;

                //Para cada amostra ou registrou ou ponto ...
                soma = 0;
                for (int i = 0; i < amostras.size(); i++) {
                	Ponto ponto = amostras.get(i); 
                    //Inicializar potencial de ativação
                    soma = soma + (amostras.get(i).limiar * pesos[0]) + (amostras.get(i).x * pesos[1]) + (amostras.get(i).y * pesos[2]);

                    //Obter a saída da rede considerando a função sinal
                    saida_gerada = funcaoAtivacaoSignal(soma);

                    //Verificar se a saída da rede é diferente da saída desejada
                    //se sim, calibrar ou treinar ou ajustar ou fazer aprender
                    if (saida_gerada != this.saidas.get(i))
                    {
                        aprendeu = false;
                        double erro = this.saidas.get(i) - saida_gerada;
                        //Fazer o ajuste dos pesos para cada elemento da amostra ou SEJA UMA CALIBRAGEM DOS PESOS
                        pesos[0] += taxa_aprendizado * erro * ponto.limiar;
                        pesos[1] += taxa_aprendizado * erro * ponto.x;
                        pesos[2] += taxa_aprendizado * erro * ponto.y;
                    }
                }
                //Atualizar contador de gerações
                conta++;

                if (aprendeu || conta > this.geracoes)
                {
                    System.out.println("Geracoes de treinamento: " + conta);
                    break;
                }
            }
        }

   
        //testes para "novas" amostras.get
        public void testar(Ponto amostra)
        {
            //Inserir o valor do limiar na posição "0" para cada amostra da lista "amostras.get"
            amostra.limiar = this.limiar;

            //Inicializar potencial de ativação
            double soma = 0;
            //# Para cada atributo...
            soma = soma + (amostra.limiar * pesos[0]) + (amostra.x * pesos[1]) + (amostra.y * pesos[2]);

            // Obter a saída da rede considerando g a função funcao_ativacao_signal
            int saida_gerada = this.funcaoAtivacaoSignal(soma);

            if (saida_gerada == 1) {
                System.out.println("Classe: " + saida_gerada + " ou Time Azul");
            } else {
                System.out.println("Classe: " + saida_gerada + " ou Time Vermelho");
            }

        }
    }


		


