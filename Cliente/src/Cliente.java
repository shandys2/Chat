import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

           final String ANSI_RESET = "\u001B[0m";
           final String ANSI_BLACK = "\u001B[30m";
           final String ANSI_RED = "\u001B[31m";
           final String ANSI_GREEN = "\u001B[32m";
           final String ANSI_YELLOW = "\u001B[33m";
           final String ANSI_BLUE = "\u001B[34m";
           final String ANSI_PURPLE = "\u001B[35m";
           final String ANSI_CYAN = "\u001B[36m";
           final String ANSI_WHITE = "\u001B[37m";

            String user;
            Scanner sc= new Scanner(System.in);
            Socket socket=new Socket("localhost",5555);
            InputStream inputStream;
            BufferedReader bufferedReader;
            OutputStream outputStream;
            BufferedWriter bufferedWriter;

            outputStream= socket.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            inputStream= socket.getInputStream();
            bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            String mensaje;

            System.out.println("1");
            HiloEscuchaServidor hiloEscuchaServidor= new HiloEscuchaServidor(bufferedReader);
            System.out.println("2");
            hiloEscuchaServidor.start();
            System.out.println("3");

            System.out.println("Introduce tu nick...");
            user= sc.nextLine();
            System.out.println("Entrando a la sala de chat...");
            while (true){

                    mensaje= sc.nextLine();
                    bufferedWriter.write(ANSI_YELLOW+ user +ANSI_RESET+":" +mensaje);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
            }
    }
}
