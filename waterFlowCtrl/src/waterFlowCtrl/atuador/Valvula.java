package waterFlowCtrl.atuador;

import java.net.*;
import java.io.*;

//ATUADOR
public class Valvula extends Thread
{
    public Socket actuatorSocket = null;
    BufferedReader in = null;
    int num = 1;

    int data = 0;

    //construtor
    public Valvula(int num, int port)
    {
        this.num = num;
        try{
            actuatorSocket = new Socket("localhost", port);
            if (actuatorSocket.isConnected())
                //System.out.println("Valvula esta conectado.");
            in = new BufferedReader(new InputStreamReader(actuatorSocket.getInputStream()));
        } catch (UnknownHostException e)
        {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to localhost.");
            System.exit(1);
        }
    }

    public void run ()
    {
        while (true)
        {
            try{
                System.out.println("Valvula "+ "recebeu = " + in.readLine());
                
            } catch (IOException e)
            {
                System.out.println("ERRO na porta");
                System.exit(-1);
            }
        }

    }
}