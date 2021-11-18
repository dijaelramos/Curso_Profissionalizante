package CursoProfissionalizante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Testes {

	static int exibirTela() {
		int opcao = 0;

		opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1-Adicionar Aluno\r\n" + 
				"2-Remover Aluno\r\n" + 
				"3-Imprimir Aluno pela posi��o de matricula\r\n" +
				"4-Imprimir todos os Alunos matriculados\r\n" + 
				"5- Situa��o\r\n" + 
				"6-Sair\r\n" +
				"\r\nINFORME A OP��O QUE DESEJA FAZER.",
				"ESCOLHA UMA OP��O", JOptionPane.INFORMATION_MESSAGE));
		return opcao;
	}

	static void matricular() {
		String matricula = JOptionPane.showInputDialog(null, "Digite a matricula do aluno", "MATRICULA DO ALUNO",
				JOptionPane.QUESTION_MESSAGE);
		String nome = JOptionPane.showInputDialog(null, "Digite o nome completo do aluno", "MATRICULA DO ALUNO",
				JOptionPane.QUESTION_MESSAGE);
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do aluno", "MATRICULA DO ALUNO",
				JOptionPane.QUESTION_MESSAGE);
		int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do aluno", "MATRICULA DO ALUNO",
				JOptionPane.QUESTION_MESSAGE));

		// C�digo para a matricula do Aluno
		if (Sala.pesquisarAluno(matricula)) {
			JOptionPane.showMessageDialog(null, "J� existe um aluno com esse nome" + nome, "ERRO NO CADASTRO!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			Sala.matricularAluno(matricula, nome, cpf, idade);
			JOptionPane.showMessageDialog(null, "Aluno Matriculado com sucesso!");
		}
	}

	static public void remover() {
		String matricula = JOptionPane.showInputDialog(null, "informe a matricula que deseja excluir",
				"Exclus�o do Aluno", JOptionPane.QUESTION_MESSAGE);

		if (Sala.removerAluno(matricula)) {
			JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!", "Exclus�o do Aluno",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel remover o aluno", "Exclus�o do Aluno",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	static public void retornarAluno() {
		int matricula = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Informe a matricula do aluno que deseja encontrar:", "BUSCAR ALUNO", JOptionPane.QUESTION_MESSAGE));

		if (Sala.novoAluno.size() < matricula + 1) {
			JOptionPane.showMessageDialog(null, "N�o h� aluno cadastrado com essa matricula: " + matricula, "Status", JOptionPane.QUESTION_MESSAGE);
		} else {
			System.out.println(Sala.novoAluno.get(matricula-1));
		}
	}

	static public void status() {
		if (Sala.novoAluno.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia! \nNenhum aluno matriculado.", "Status",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			
			//Collections.sort(Sala.novoAluno.);
			System.out.println("------------ LISTA DOS ALUNOS MATRICULADOS -----------------------");
			System.out.println(Sala.novoAluno);
			System.out.println("--------------------------- FIM DA LISTA --------------------------");
		}
	}
	
	static public void inserirNota() {
		ArrayList<Double> notasAluno = new ArrayList<>();
		
		int matricula = Integer.parseInt(JOptionPane.showInputDialog(null,
		"Informe a matricula do aluno que deseja dar uma nota", "BUSCAR ALUNO", 
		JOptionPane.QUESTION_MESSAGE));

		if (Sala.novoAluno.size() < matricula + 1) {
			JOptionPane.showMessageDialog(null, "N�o h� aluno cadastrado com essa matricula: " + matricula, "Status", 
					JOptionPane.QUESTION_MESSAGE);
		} else {
			double nota1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a Primeira nota do aluno", "SITUA��O DO ALUNO",
					JOptionPane.QUESTION_MESSAGE));
			
			double nota2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a segunda nota do aluno", "SITUA��O DO ALUNO",
					JOptionPane.QUESTION_MESSAGE));
			
			notasAluno.add(nota1);
			notasAluno.add(nota2);
			double media = (nota1 + nota2)/2;
			
			if (media>=7) {
				JOptionPane.showMessageDialog(null, Sala.novoAluno.get(matricula -1) + 
						"\nM�dia: " + media + ", foi Aprovado", "SITUA��O", JOptionPane.INFORMATION_MESSAGE);
			} else if(media>=4) {
				JOptionPane.showMessageDialog(null, Sala.novoAluno.get(matricula -1) + 
						"\nM�dia: " + media + ", est� na final", "SITUA��O", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, Sala.novoAluno.get(matricula -1) + 
						"\nM�dia: " + media + ", est� reprovado", "SITUA��O", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

//	private String getNome() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
