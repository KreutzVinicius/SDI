import java.io.*;
import java.net.*;
import java.util.*;

class Cliente {

    public static void main(String argv[]) throws Exception {
        String sentence = "";
        String aux;
        String modifiedSentence;
        BufferedReader br = null;
        FileReader fr = null;

        Scanner sc = new Scanner(System.in);
        // concatenar string cliente
        while (sc.hasNextLine() == true) {
            if (sc.nextLine() == "##Clientes##;") {
                while (sc.hasNextLine() == true) {
                    aux = sc.nextLine();

                    if (sc.nextLine() == "###;") {
                        break;
                    } else {
                        sentence = sentence + aux;
                    }
                }

            }
        }

        Socket clientSocket = new Socket("ens1", 9995);

        DataOutputStream outToServer = new DataOutputStream(
                clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(sentence);
        modifiedSentence = inFromServer.readLine();

        System.out.println(modifiedSentence);

        sc.close();
        clientSocket.close();

        System.exit(0);

    }
}
