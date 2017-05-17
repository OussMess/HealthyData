import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Flux {


    public static void main(String[] zero) {

        ServerSocket socketserver  ;
        Socket socketduserveur ;
        BufferedReader in;
        PrintWriter out;

        try {

            socketserver = new ServerSocket(9999);
            System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
            socketduserveur = socketserver.accept();
            System.out.println("Un zéro s'est connecté");
            out = new PrintWriter(socketduserveur.getOutputStream());
            while(true){
                int a = (int)(Math.random()*100);
                int b = (int)(Math.random()*100);
                System.out.println("p1;s1;m1:"+a+" p2;s2;m3:"+b);
                out.println("p1;s1;m1:"+a+" p2;s3;m3:"+b+" p1;s2;m2:"+a);
                out.flush();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //socketduserveur.close();
            //socketserver.close();

        }catch (IOException e) {

            e.printStackTrace();
        }
    }
}
