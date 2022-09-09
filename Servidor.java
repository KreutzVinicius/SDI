import java.io.*;
import java.net.*;

class Servidor {

    public static void main(String argv[]) throws Exception {
        String clientSentence = "";
        Integer cont = 0;
        ServerSocket welcomeSocket = new ServerSocket(9995);

        Scanner sc = new Scanner(System.in);
        // concatenar string cliente
        while (sc.hasNextLine() == true) {
            if (sc.nextLine() == "##Servidor##;") {
                while (sc.hasNextLine() == true) {
                    aux = sc.nextLine();
                    if (sc.nextLine() == "##Clientes##;") {
                        break;
                    } else {
                        // define palavras que vao ser buscadas
                    }
                }

            }
        }

        // System.out.println("Servidor pronto ...");

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();
            System.out.println(clientSentence);
            // procura palavras no clientSentence

            // envia
            // System.out.println("##RELATORIO##;");
            // palavra=2;
            // System.out.println("###;");

            outToClient.writeBytes(clientSentence);

            cont++;
            if (cont == 1) {
                // System.out.println("Servidor finalizado com sucesso!");
                System.exit(0);
            }
        }
    }
}
