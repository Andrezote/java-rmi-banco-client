package aula.rmi.banco.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;

import javax.swing.JOptionPane;

import banco.rmi.remote.IRemoteBanco;

public class Usuario1 {

	public static void main(String[] args) {

		System.out.println("Registrando no servidor remoto...");

		try {
			Registry registry = LocateRegistry.getRegistry(9876);
			Instant inicio;
			Instant fim;

			IRemoteBanco stub = (IRemoteBanco) registry.lookup("Servidor_aula");
			int flag = 1;
			while (flag != 0) {
				int opcao = Integer.parseInt(
						(JOptionPane.showInputDialog("1-deposito \n" + "2-saque \n" + "3-saldo \n" + "4-sair")));
				switch (opcao) {
				case 1:
					double valor = Double
							.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja depositar"));
					stub.deposito(valor, 1);
					break;
				case 2:
					inicio = Instant.now();
					double valorsaque = Double
							.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja Sacar"));
					stub.saque(valorsaque, 1,inicio);
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Seu saldo é " + stub.saldo(1));
					break;
				case 4:
					flag = 0;
					break;
				default:
					System.out.println("valor invalido");
					;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
