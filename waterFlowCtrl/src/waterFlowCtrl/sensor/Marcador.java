package waterFlowCtrl.sensor;


import java.net.*;
import java.io.*;

//SENSOR
public class Marcador
{
    public Socket sensorSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    int data = 0;

    //construtor
    public Marcador(int num, int port)
    {
        try{
            sensorSocket = new Socket("localhost", port);
            if (sensorSocket.isConnected())
                //System.out.println("Marcador esta conectado.");
            out = new PrintWriter(sensorSocket.getOutputStream(), true);
        } catch (UnknownHostException e)
        {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e)
        {
            System.err.println("Não foi possivel pega a entrada para o localhost.");
            System.exit(1);
        }
    }

    public void sendMsg()
    {
        System.out.println("\nRelogio  envia dados = " + data);
        out.println(data);
        data++;
    }
}

