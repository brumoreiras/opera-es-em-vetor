/*
Entrega a Atividade 1 - Algoritmos e Programação II

Nós,

Bruno Moreira Santos 
Juliana Mariano Viana 
Kayky Yan Santos Severino

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou 
prejudicar outros.

*/

package ExecucaoDeAtividade;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class OperacoesEmVetores {

	public static void main(String[] args) {
		Scanner dadosDeEntrada = new Scanner(System.in);

		int tamanhoDoVetor = 0;
		int limiteDeNumerosAleatorio; // Representa até onde é permitido criar os numeros aleatorios para preencher as
										// posições do vetor.
		int buscarNumero; // Variável responsável em receber dados via teclado.
		int opcao;
		int[] operarVetor = new int[tamanhoDoVetor];

// Menu de inicialização
		do {
			opcao = exibirMenu();

			if ((operarVetor.length == 0 && (opcao > 1 && opcao <= 8))) {
				System.out.println("\nO VETOR NAO FOI INICIALIZADO!\n");
			} else {
				switch (opcao) {
				case 0:
					System.out.println("\n SAIU \n\n");
					break;
				case 1:
					System.out.print("\nINFORME O TAMANHO DO VETOR: ");
					tamanhoDoVetor = dadosDeEntrada.nextInt();
					if (tamanhoDoVetor <= 0) {
						System.out.println("\nO NUMERO NAO PODE SER ZERO E NEGATIVO");
						System.out.print("DIGITE UM NOVO NUMERO: ");
						tamanhoDoVetor = dadosDeEntrada.nextInt();
					}

					System.out.print("DIGITE UM NUMERO: ");
					limiteDeNumerosAleatorio = dadosDeEntrada.nextInt();
					if (limiteDeNumerosAleatorio <= 0) {
						System.out.println("\nO NUMERO NAO PODE SER ZERO E NEGATIVO");
						System.out.print("DIGITE UM NOVO NUMERO: ");
						limiteDeNumerosAleatorio = dadosDeEntrada.nextInt();
					}

					Random criaNumerosAleatorio = new Random();
					operarVetor = new int[tamanhoDoVetor];

					for (int i = 0; i < operarVetor.length; i++) {
						operarVetor[i] = criaNumerosAleatorio.nextInt(limiteDeNumerosAleatorio + 1);
					}
					break;

				case 2:
					imprimirVetor(operarVetor);
					break;

				case 3:
					System.out.print("\nDIGITE UM NUMERO PARA BUSCAR SEU INDICE NO VETOR: ");
					buscarNumero = dadosDeEntrada.nextInt();
					int retornoDaBusca = verificarNumero(operarVetor, buscarNumero);
					if (retornoDaBusca < 0) {
						System.out.printf("\nNUMERO NAO ENCONTRADO NO VETOR\n\n");
					} else {
						System.out.printf("\nNUMERO ENCONTRADO, NO INDICE %d\n\n", retornoDaBusca);
					}
					break;

				case 4:
					System.out.printf("\nO MAIOR VALOR ENCONTRADO NO VETOR EH: %d\n\n", buscaMaiorValor(operarVetor));
					break;

				case 5:
					System.out.printf("\nA MEDIA DA SOMA DOS NUMEROS PARES EH: %.1f\n\n",
							calcularMediaDosNumerosPares(operarVetor));
					break;

				case 6:
					System.out.printf("\nO PERCENTUUAL DOS NUMEROS IMPARES EH: %d%% \n\n",
							calcularPercentualDosNumerosImpares(operarVetor));
					break;

				case 7:
					System.out.printf("\nO CALCULO DA MEDIA CENTRALIZADA EH: %.1f\n\n",
							calcularMediaCentralizada(operarVetor));
					break;

				case 8:
					System.out.print("\nDIGITE UM NUMERO: ");
					buscarNumero = dadosDeEntrada.nextInt();
					System.out.printf("\n%b\n\n", existeDoisNumeros(operarVetor, buscarNumero));
					break;

				default:
					System.out.println("\nOPCAO INVALIDA!\n");
				}
			}

		} while (opcao != 0);

		dadosDeEntrada.close();
	}

//1. Menu
	public static int exibirMenu() {
		Scanner entradaDeOpcao = new Scanner(System.in);
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("|                            *** MENU DE OPCOES ***                          |");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("|    (1) INICIALIZAR VETOR                                                   |");
		System.out.println("|    (2) IMPRIMIR O VETOR                                                    |");
		System.out.println("|    (3) BUSCAR NUMERO NO VETOR                                              |");
		System.out.println("|    (4) BUSCAR O MAIOR NUMERO CONTIDO NO VETOR                              |");
		System.out.println("|    (5) CALCULAR MEDIA DOS NUMEROS PARES                                    |");
		System.out.println("|    (6) CALCULAR PERCENTUAL DOS NUMEROS IMPARES                             |");
		System.out.println("|    (7) CALCULAR MEDIA CENTRALIZADA DOS NUMEROS                             |");
		System.out.println("|    (8) BUSCAR SE DOIS NUMEROS SOMADOS EH IGUAL AO NUMERO INFORMADO         |");
		System.out.println("|    (0) SAIR                                                                |");
		System.out.println("+----------------------------------------------------------------------------+\n");
		System.out.print(" ESCOLHA UMA OPCAO: ");

		return entradaDeOpcao.nextInt();

	}

//2.	 Imprimir o vetor
	public static void imprimirVetor(int[] vetor) {
		System.out.println("\nVETOR CRIADO: " + Arrays.toString(vetor) + "\n");
	}

//3.	Verificar se um determinado número está contido no vetor
	public static int verificarNumero(int[] operarVetor, int buscar) {
		for (int i = 0; i < operarVetor.length; i++) {
			if (operarVetor[i] == buscar) {
				return i;
			}
		}
		return -1;
	}

//4.	Buscar o maior número armazenado no vetor
	public static int buscaMaiorValor(int[] buscarNoVetor) {
		int maiorValor = buscarNoVetor[0];
		for (int i = 0; i < buscarNoVetor.length; i++) {
			if (i == 0) {
				maiorValor = buscarNoVetor[i];
			} else if (buscarNoVetor[i] > maiorValor) {
				maiorValor = buscarNoVetor[i];
			}
		}
		return maiorValor;
	}

//5.	Calcular a média dos números pares armazenados no vetor
	public static double calcularMediaDosNumerosPares(int[] buscarNumerosPares) {
		int numerosPares = 0;
		double mediaDosNumerosPares;
		int divisor = 0;
		for (int i = 0; i < buscarNumerosPares.length; i++) {
			if (buscarNumerosPares[i] % 2 == 0) {
				numerosPares += buscarNumerosPares[i];
				divisor += 1;
			}
		}
		mediaDosNumerosPares = (double) numerosPares / divisor;
		return mediaDosNumerosPares;
	}

//6.	Calcular o percentual dos números ímpares armazenados no vetor
	public static int calcularPercentualDosNumerosImpares(int[] numerosImpares) {
		int acumulador = 0;
		int percentual;
		for (int i = 0; i < numerosImpares.length; i++) {
			if (numerosImpares[i] % 2 == 1) {
				acumulador += 1;
			}
		}
		percentual = ((acumulador * 100) / numerosImpares.length);
		return percentual;
	}

//7.	Calcula a média centralizada dos números armazenados no vetor
	public static double calcularMediaCentralizada(int[] mediaDosNumerosCentralizados) {
		double mediaCentralizada = 0;
		int descarteMaiorNumero = mediaDosNumerosCentralizados[0];
		int descarteMenorNumero = mediaDosNumerosCentralizados[0];
		int somaDosNumerosCentralizados = 0;
		for (int i = 0; i < mediaDosNumerosCentralizados.length; i++) {
			if (mediaDosNumerosCentralizados[i] > descarteMaiorNumero) {
				descarteMaiorNumero = mediaDosNumerosCentralizados[i];
			} else if (mediaDosNumerosCentralizados[i] < descarteMenorNumero) {
				descarteMenorNumero = mediaDosNumerosCentralizados[i];
			}
			somaDosNumerosCentralizados += mediaDosNumerosCentralizados[i];
		}
		mediaCentralizada = (double) (somaDosNumerosCentralizados - descarteMaiorNumero - descarteMenorNumero)
				/ (mediaDosNumerosCentralizados.length - 2);
		return mediaCentralizada;
	}

//8.	Verificar se, dado um valor, existe dois números em posições distintas que somados é 
	// igual ao valor informado por parâmetro
	public static boolean existeDoisNumeros(int[] contemDoisNumeros, int buscarNumeroNoVetor) {
		int somaDoisNumeros = 0;
		for (int i = 0; i < contemDoisNumeros.length; i++) {
			for (int j = 0; j < contemDoisNumeros.length; j++) {
				if (i != j && contemDoisNumeros[i] != 0 && contemDoisNumeros[j] != 0) {
					somaDoisNumeros = contemDoisNumeros[i] + contemDoisNumeros[j];
				}
				if (buscarNumeroNoVetor == somaDoisNumeros) {
					return true;
				}
			}

		}
		return false;
	}
}
