package br.edu.univas;

import java.util.Scanner;

public class StartApp {

	static Scanner reading = new Scanner(System.in);
	static Jogo[] jogos = new Jogo[50];
	static Time[] times = new Time[50];
	static int indexJogo, indexTime = 0;

	public static void main(String[] args) {

		int opcao = 0;
		do {
			listOpetions();
			opcao = reading.nextInt();
			switch (opcao) {
			case 1:
				newTime();
				break;
			case 2:
				editTime();
				break;
			case 3:
				deleteTime();
				break;
			case 4:
				newGame();
				break;
			case 5:
				editGame();
				break;
			case 6:
				deleteGame();
				break;
			case 7:
				listCamp();
				break;
			case 9:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}

		} while (opcao != 9);

		System.out.println("Fim");

	}

	private static void newTime() {
		Time t = new Time();
		System.out.println("Digite o nome do time:");
		String nomeTime = reading.next();
		reading.nextLine();
		t.setNomeTime(nomeTime);
		System.out.println("Digite o Estado do time: ");
		String estadoTime = reading.next();
		reading.nextLine();
		t.setEstadoTime(estadoTime);
		times[indexTime] = t;
		indexTime++;
	}

	private static void editTime() {
		System.out.println("Digite o index do time a ser editado:");
		int indexT = reading.nextInt();
		if (indexT > indexTime || indexT < 0) {
			System.out.println("Index não cadastrado ou incorreto");
			return;
		}

		System.out.println("Digite o nome do time:");
		String nomeTime = reading.next();
		System.out.println("Digite o Estado do time: ");
		String estadoTime = reading.next();

		Time t = new Time();
		t.setNomeTime(nomeTime);
		t.setEstadoTime(estadoTime);
		times[indexT] = t;
	}

	private static void deleteTime() {
		System.out.println("Digite o index do time a ser deletado:");
		int indexT = reading.nextInt();
		if (indexT > indexTime || indexT < 0) {
			System.out.println("Index não cadastrado ou incorreto");
			return;
		}

		times[indexT].setNomeTime(null);
		times[indexT].setEstadoTime(null);

	}

	private static void newGame() {
		Jogo j = new Jogo();
		System.out.println("Digite o nome do time mandante:");
		String timeMandante = reading.next();
		reading.nextLine();
		j.setTimeMandante(timeMandante);

		System.out.println("Digite o nome do time visitante:");
		String timeVisitante = reading.next();
		reading.nextLine();
		j.setTimeVisitante(timeVisitante);

		System.out.println("Digite os gols do time mandante:");
		int golsTimeMandante = reading.nextInt();
		reading.nextLine();
		j.setGolsMandante(golsTimeMandante);

		System.out.println("Digite os gols do time visitante:");
		int golsTimeVisitante = reading.nextInt();
		reading.nextLine();
		j.setGolsVisitante(golsTimeVisitante);

		for (int i = 0; i < indexJogo; i++) {
			for (int j1 = 0; j1 < indexTime; j1++) {

				if (jogos[i].getTimeVisitante().contentEquals(times[j1].getNomeTime())) {
					if (golsTimeMandante < golsTimeVisitante) {
						times[j1].setPontos(times[j1].getPontos() + 3);
					} else if (golsTimeMandante == golsTimeVisitante) {
						times[j1].setPontos(times[j1].getPontos() + 1);
					}
				}

				if (jogos[i].getTimeMandante().contentEquals(times[j1].getNomeTime())) {
					if (golsTimeMandante > golsTimeVisitante) {
						times[j1].setPontos(times[j1].getPontos() + 3);
					} else if (golsTimeMandante == golsTimeVisitante) {
						times[j1].setPontos(times[j1].getPontos() + 1);
					}
				}

			}
		}

	}

	private static void editGame() {

		System.out.println("Digite o index do jogo a ser editado:");
		int indexJ = reading.nextInt();
		if (indexJ > indexTime || indexJ < 0) {
			System.out.println("Index não cadastrado ou incorreto");
			return;
		}

		System.out.println("Digite o nome do time mandante:");
		String timeMandante = reading.next();
		reading.nextLine();
		System.out.println("Digite o nome do time visitante:");
		String timeVisitante = reading.next();
		reading.nextLine();

		System.out.println("Digite os gols do time mandante:");
		int golsMandante = reading.nextInt();
		reading.nextLine();

		System.out.println("Digite os gols do time visitante:");
		int golsVisitante = reading.nextInt();
		reading.nextLine();

		Jogo j = new Jogo();
		j.setTimeMandante(timeMandante);
		j.setGolsMandante(golsMandante);
		j.setTimeVisitante(timeVisitante);
		j.setGolsVisitante(golsVisitante);

		jogos[indexJ] = j;
	}

	private static void deleteGame() {
		System.out.println("Digite o index do jogo a ser deletado:");
		int indexJ = reading.nextInt();
		if (indexJ > indexJogo || indexJ < 0) {
			System.out.println("Index não cadastrado ou incorreto");
			return;
		}

		jogos[indexJ].setTimeMandante(null);
		jogos[indexJ].setTimeVisitante(null);
		jogos[indexJ].setGolsMandante(0);
		jogos[indexJ].setGolsVisitante(0);

	}

	private static void listCamp() {
		Time[] auxTimes = times;
		for (int i = 0; i < indexTime; i++) {
			System.out.println("Time " + auxTimes[i].getNomeTime() + " - " + auxTimes[i].getPontos() + " pontos - "
					+ auxTimes[i].getSaldoGols() + "de saldo de");
		}

	}

	static void listOpetions() {
		System.out.println("Escolhe uma opção do menu:");
		System.out.println("1 – Cadastrar Time");
		System.out.println("2 – Editar Time");
		System.out.println("3 – Excluir Time");
		System.out.println("4 – Cadastrar Jogo");
		System.out.println("5 – Editar Jogo");
		System.out.println("6 – Excluir Jogo");
		System.out.println("7 – Listar Classificação do Campeonato");
		System.out.println("9 - Sair");
		System.out.println();
	}

}
