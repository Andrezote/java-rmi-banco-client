package aula.rmi.banco.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import banco.rmi.remote.IRemoteBanco;

public class Usuario2 {
public static void main(String[] args) {
		
		System.out.println("Registrando no servidor remoto...");
		
		
		try {
			Registry registry = LocateRegistry.getRegistry(9876);
			
			IRemoteBanco stub =  (IRemoteBanco)
					registry.lookup("Servidor_aula");
			stub.deposito(100, 1);
			System.out.println(stub.saldo(1));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
