package waterFlowCtrl.controlador;


import java.io.*;
import java.util.*;

import waterFlowCtrl.atuador.Valvula;
import waterFlowCtrl.sensor.Marcador;
import waterFlowCtrl.simSocket.controleSocket;

//CONTROLADOR
public class Arduino extends Thread
{

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
    {
    	controleSocket ctrl = new controleSocket(1, 4440, 4450); //porta de espera pelo Marcador e porta de conexao ao atuador

        Valvula actu = new Valvula(1, 4450);

        TimerTask task = new TimerTask()
        {
            Marcador SEN = new Marcador(1, 4440);
            @Override
			public void run()
            {
                SEN.sendMsg();
            }
        };
        Scanner sr=new Scanner(System.in);
		System.out.println("Digite o período que deseja monitorar:");
		int a=sr.nextInt();
        ctrl.start();
        actu.start();
        Timer timer = new Timer();
        timer.schedule(task, 0, a*1000);

     }
}