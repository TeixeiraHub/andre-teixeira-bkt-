package ImpostoRenda.RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Servidor extends UnicastRemoteObject implements Servico {

	private Registry r;
	public Servidor() throws RemoteException
	{
		r = LocateRegistry.createRegistry(3232);
		r.rebind ("Calculadora", this);
	}

	@SuppressWarnings("resource")
	public void ServCalc() throws RemoteException
	{
		Scanner sr=new Scanner(System.in);
		System.out.println("Digite o seu salario:");
		double a=sr.nextInt();

		while(true)
		{

			if(a<0)
			{
				System.out.println("N�o podem ser inseridos valores negativos!" + "\nTente novamente!");
			}
			if (a <= 1868.22)
			{
				System.out.println("Voc� � isento do IPRF!");
			}
			if (a>=1868.23 && a<=2799.86)
			{
				System.out.println("Seu desconto de IPRF �: " +irCalcBase1(a));
			}
			if (a>=2799.87 && a<=3733.19)
			{
				System.out.println("Seu desconto de IPRF �: " +irCalcBase2(a));
			}
			if (a>=3733.20 && a<=4664.68)
			{
				System.out.println("Seu desconto de IPRF �: " +irCalcBase3(a));
			}
			else if(a>=4664.68)
			{
				System.out.println("Seu desconto de IPRF �: " +irCalcBase4(a));
			}
			break;
			}
		}
		
		public double irCalcBase1(double a) throws RemoteException
		{
			double c = 140.12;
			double b = 0.075;
			return (a*b)-c;
		}

		public double irCalcBase2(double a) throws RemoteException
		{
			double c = 350.11;
			double b = 0.15;
			return (a*b)-c;
		}

		public double irCalcBase3(double a) throws RemoteException
		{
			double c = 630.10;
			double b = 0.225;
			return (a*b)-c;
		}

		public double irCalcBase4(double a) throws RemoteException
		{
			double c = 863.33;
			double b = 0.275;
			return (a*b)-c;
		}
	}

