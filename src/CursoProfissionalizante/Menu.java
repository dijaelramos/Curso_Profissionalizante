package CursoProfissionalizante;

import javax.swing.JOptionPane;

public class Menu extends Aluno {

	public static void main(String[] args) {
		int tela = 0;

		do {
			tela = Testes.exibirTela();

			switch (tela) {
			case 1:
				Testes.matricular();
				break;
			case 2:
				Testes.remover();
				break;
			case 3:
				Testes.retornarAluno();
				break;
			case 4:
				Testes.status();
				break;
			case 5:
				//Situação do aluno
				Testes.inserirNota();
				break;
			case 6:
				System.out.println("Saindo...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!", "ERRO NO DIGITO!", JOptionPane.ERROR_MESSAGE);
			}

		} while (tela != 6);
	}
}






