import java.io.*;
import java.net.Socket;
import java.util.Date;

public class HiloCliente extends Thread {

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_WHITE = "\u001B[37m";

    InputStream inputStream;
    BufferedReader bufferedReader;
    OutputStream outputStream;
    BufferedWriter bufferedWriter;

    Socket socket;
    Date fecha=null;

    public HiloCliente(Socket soc){
        this.socket=soc;

    }

    @Override
    public void run(){

        try {
            inputStream = socket.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            outputStream=socket.getOutputStream();
            bufferedWriter= new BufferedWriter(new OutputStreamWriter(outputStream));
            String line;

            while ((line=bufferedReader.readLine())!=null){

                System.out.println( ANSI_CYAN+getFecha()+line);
                Servidor.broadcast(ANSI_CYAN+getFecha()+line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFecha(){
        String h,m,s;
        fecha= new Date();
        int hora=fecha.getHours();
        int min= fecha.getMinutes();
        int seg= fecha.getSeconds();

        if(hora<10){
             h= "0"+hora;
        }else{
             h= String.valueOf(hora);
        }
        if(min<10){
             m= "0"+min;
        }else{
            m= String.valueOf(min);
        }
        if(seg<10){
             s= "0"+seg;
        }else{
            s= String.valueOf(seg);
        }

        return "["+h+":"+m+":"+s+"]";
    }


}
