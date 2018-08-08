package ImpostoRenda.RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SuppressWarnings("serial")
public class Cliente extends Servidor {
	
	private Registry r;
	private Servico s;
	
	public Cliente() throws RemoteException, NotBoundException
	{
		r=LocateRegistry.getRegistry("192.168.1.7", 3232);
		s=(Servico)r.lookup("Calculadora");

	}
		
	public static void main(String[]args) throws RemoteException, NotBoundException
	{
		Cliente c=new Cliente();
		c.ServCalc();
	}
}
