package CursoProfissionalizante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sala extends Aluno {

	static int totAlunos = 20;
	static public List<Aluno> novoAluno = new ArrayList<>();

	static public boolean matricularAluno(String matricula, String nome, String cpf, int idade) {

		try {
			Aluno a = new Aluno(matricula, nome, cpf, idade);
			if (novoAluno.size() <= totAlunos) {
				if (novoAluno.add(a)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("O tamanho da Matricula é até " + totAlunos);
			e.printStackTrace();
		}
		return false;
	}

	static public int retornarPosicaoAluno(String matricula) {

		try {
			for (Aluno a : novoAluno) {
				if (a.getMatricula().equalsIgnoreCase(matricula)) {
					return novoAluno.indexOf(a);
				}
			}
		} catch (Exception e) {
			System.out.println("Não foi possível retornar a posição do aluno " + e.getMessage());
			e.printStackTrace();
		}
		return -1;
	}

	static public boolean removerAluno(String matricula) {

		try {
			for (Aluno a : novoAluno) {
				if (a.getMatricula().equalsIgnoreCase(matricula)) {
					novoAluno.remove(a);
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println("Não foi possível remover o aluno " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	static public boolean pesquisarAluno(String matricula) {

		try {
			for (Aluno a : novoAluno) {
				if (a.getMatricula().equalsIgnoreCase(matricula)) {
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println("Não foi possível pesquisar o aluno " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}	
