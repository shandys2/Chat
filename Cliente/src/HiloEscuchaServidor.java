import java.io.BufferedReader;

public class HiloEscuchaServidor extends Thread{

    BufferedReader bufferedReader;
    public HiloEscuchaServidor(BufferedReader bf){
        this.bufferedReader=bf;
    }

    @Override
    public void run(){

        String res;
        try {
            while ((res=bufferedReader.readLine())!=null){
                   System.out.println(res);

            }
        }catch (Exception e){

        }

    }


}
