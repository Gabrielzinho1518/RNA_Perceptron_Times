package pacote;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[]args){
        System.out.println("Exemplo de RNA Perceptron para classificação de equipes");
        
        List<Ponto> amostras = new ArrayList<Ponto>();

            amostras.add(new Ponto(0.72, 0.82));
			amostras.add(new Ponto(0.91, -0.69));
			amostras.add(new Ponto(0.46, 0.80));
			amostras.add(new Ponto(0.03, 0.93));
			amostras.add(new Ponto(0.12, 0.25));
			amostras.add(new Ponto(0.96, 0.47));
			amostras.add(new Ponto(0.8, -0.75));
			amostras.add(new Ponto(0.46, 0.98));
			amostras.add(new Ponto(0.66, 0.24));
			amostras.add(new Ponto(0.72, -0.15));
			amostras.add(new Ponto(0.35, 0.01));
			amostras.add(new Ponto(-0.16, 0.84));
			amostras.add(new Ponto(-0.04, 0.68));
			amostras.add(new Ponto(-0.11, 0.1));
			amostras.add(new Ponto(0.31, -0.96));
			amostras.add(new Ponto(0.0, -0.26));
			amostras.add(new Ponto(-0.43, -0.65));
			amostras.add(new Ponto(0.57, -0.97));
			amostras.add(new Ponto(-0.47, -0.03));
			amostras.add(new Ponto(-0.72, -0.64));
			amostras.add(new Ponto(-0.57, 0.15));
			amostras.add(new Ponto(-0.25, -0.43));
			amostras.add(new Ponto(0.47, -0.88));
			amostras.add(new Ponto(-0.12, -0.9));
			amostras.add(new Ponto(-0.58, 0.62));
			amostras.add(new Ponto(-0.48, 0.05));
			amostras.add(new Ponto(-0.79, -0.92));
			amostras.add(new Ponto(-0.42, -0.09));
			amostras.add(new Ponto(-0.76, 0.65));
			amostras.add(new Ponto(-0.77, -0.76));

			List<Integer> saidas = new ArrayList<>();
			saidas.add(-1); saidas.add(-1); saidas.add(-1); saidas.add(-1); saidas.add(-1);
            saidas.add(-1); saidas.add(-1); saidas.add(-1); saidas.add(-1); saidas.add(-1);
            saidas.add(-1); saidas.add(-1); saidas.add(-1);
            saidas.add(1); saidas.add(1); saidas.add(1); saidas.add(1); saidas.add(1);
            saidas.add(1); saidas.add(1); saidas.add(1); saidas.add(1); saidas.add(1);
            saidas.add(1); saidas.add(1); saidas.add(1); saidas.add(1); saidas.add(1);
            saidas.add(1); saidas.add(1);

			double taxa_aprendizado = 0.1;
            int geracoes = 1000;
            int limiar = 1;
            Perceptron p = new Perceptron(amostras, saidas, taxa_aprendizado, geracoes, limiar);
            p.treinar();
            Scanner scanner = new Scanner(System.in);

			String op;
			do
			{
				System.out.println("\n\nInforme valor para x (-1 a 1): ");
				double x = Double.parseDouble(scanner.nextLine() );
				System.out.println("Informe valor para y (-1 a 1): ");
				double y = Double.parseDouble(scanner.nextLine() );

				p.testar(new Ponto(x,y));
				System.out.println("1 - Sair: ");
				op = scanner.nextLine();
			} while (!op.equals("1"));

            scanner.close();
			
        }
    }











