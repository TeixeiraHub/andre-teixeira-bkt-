package waterFlowCtrl.simSocket;


import java.net.*;
import java.io.*;

public class controleSocket extends Thread
{

   
	public ServerSocket serverSocketSens = null;
    public ServerSocket serverSocketAct = null;

    public Socket senSocket = null;
    public Socket actSocket = null;
    public int port = 0;
    public String idHost = "Controle";
    public int numCtrl = 0;
    public int numArd = 1;

    public controleSocket (int num, int portSens, int portAct)
    {
        numCtrl = num;
        port =  portSens;

        try
        {
            serverSocketSens = new ServerSocket(portSens);

        } catch (IOException e)
        {
            System.out.println("Erro na porta de comunicacao do marcador!");
            System.exit(-1);
        }
        port =  portAct;
        try
        {

            serverSocketAct = new ServerSocket(port);
        } catch (IOException e)
        {
            System.out.println("Erro na porta de comunicacao da valvula!");
            System.exit(-1);
        }
    }


    public void run ()
    {
        try
        {
            System.out.println("\nArduino aguardando conexao do marcador e da valvula...");
            senSocket = serverSocketSens.accept();
            if (senSocket.isConnected())
                System.out.println("\nRelogio conectado ao Arduino...");

            actSocket = serverSocketAct.accept();

            if (actSocket.isConnected())
            {
                System.out.println("Valvula conectado ao Arduino...");
            }

        } catch (UnknownHostException e)
        {
            System.err.println("Host desconhecido!");
            System.exit(1);
        } catch (IOException e)
        {
            System.err.println("Timeout de conexao do Marcador expirado!");
        }
        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(senSocket.getInputStream()));
            PrintWriter os = new PrintWriter(actSocket.getOutputStream(), true);
            int inputData;
            String frameTX;

            while (true)
            {
                frameTX = is.readLine();
                System.out.println("Arduino "+ "recebeu = " + frameTX);
                inputData = Integer.parseInt(frameTX);
                inputData = inputData + 10;
                os.println(idHost +" "+ numCtrl + " \nvalor em L : " + inputData);
                numCtrl++;
                os.flush();
	
            }
        } catch (IOException e)
        {
            System.out.println("ERRO na porta");
            System.exit(-1);
        }
    }

}