package ImpostoRenda.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servico extends Remote{
	public double irCalcBase1(double a) throws RemoteException;
	public double irCalcBase2(double a) throws RemoteException;
	public double irCalcBase3(double a) throws RemoteException;
	public double irCalcBase4(double a) throws RemoteException;
}