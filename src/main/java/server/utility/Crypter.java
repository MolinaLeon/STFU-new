//Klasse er lånt fra https://github.com/Pewtro/STFU-new/blob/master/src/main/java/server/utility/Crypter.java
//Krypteringsmetoden er blevet splittet op i to de- og encrypt i stedet for en

package server.utility;

import com.google.gson.Gson;
import server.config.Config;

public class Crypter {

    /**
     * @param input
     * @return Input
     */
    public static String encrypt(String input) {

        if (Config.getEncryption()) {
            char[] key = {'J', 'M', 'F'};
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                output.append((char) (input.charAt(i) ^ key[i % key.length]));
            }

            String encrypted = new Gson().toJson(output.toString());

            return encrypted;
        } else {
            return input;
        }
    }

    public String decrypt(String input) {
        if (Config.getEncryption()) {
            char[] key = {'J', 'M', 'F'};
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                output.append((char) (input.charAt(i) ^ key[i % key.length]));
            }

            String decrypted = output.toString();

            return decrypted;
        } else {
            return input;
        }
    }
}





