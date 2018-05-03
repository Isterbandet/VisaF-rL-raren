
package tcpsocket;

import java.io.*;
import java.net.*;

class TCPSocket 
{
   public static void main(String argv[]) throws Exception
   {
      String sentence;
      String modifiedSentence;
      String hostName = "127.0.0.1";

      BufferedReader inFromUser = 
         new BufferedReader(
         new InputStreamReader(System.in));

      Socket clientSocket = new Socket(hostName, 1337);

      DataOutputStream outToServer =
         new DataOutputStream(
         clientSocket.getOutputStream());

      BufferedReader inFromServer =
         new BufferedReader(
         new InputStreamReader(
         clientSocket.getInputStream()));

      sentence = inFromUser.readLine();

      outToServer.writeBytes(sentence + '\n');

      modifiedSentence = inFromServer.readLine();

      System.out.println("FROM SERVER: " + modifiedSentence);

      clientSocket.close();
   }
}