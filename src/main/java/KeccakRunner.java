import BobulousKeccak.BobulousKeccak;
import Jeok70Keccak.Jeok70Keccak;
import KeccakJ.KeccakJ;
import jrmelshaKeccak.JrmKeccak;
import net.rapidhashing.cryptonight.Cryptonight;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;



public class KeccakRunner {
    public static void main(String[] args) {
        System.out.println("Sandbox for testing out different keccak implementations!!!");

        String message;

        message = "This is a test";

        byte[] testHexMessage = hexStringToByteArray("0505fbf6ffcb050b68956935c6c2902af098f48b969d6e3577647e80c556d90ab2415c2996bb1625004000676466b9986865ae42affe0bf4b86a43129156457c76bd1968d087cc8a1bd46606");

//        byte[] outputBuffer = new byte[32];
//        Cryptonight.fastHash(message.getBytes(), outputBuffer);
//        String cryptoOut = new String(Hex.encode(outputBuffer));
//        System.out.println(cryptoOut);


        //25
        //fa52390715ce6d0e7fc7966639f9840aaf95331c4b389b0a40

//        BobulousKeccak keccak = new BobulousKeccak(message.getBytes());
//
//        byte[] out = keccak.returnHash();
//
//            System.out.println(out.length);
//
////        for (byte b : out) {
////            System.out.println(Integer.toBinaryString(b & 255 | 256).substring(1));
////        }
//
//            String hexOut = bytesToHex(out);
//
//            System.out.println(hexOut);



        //25
        //458e4ddd8fd7a4c55cf2ab5651d1b0de4e3bb51bba675a509b

        JrmKeccak jrmKeccak = new JrmKeccak();

        jrmKeccak.update(testHexMessage);

        byte[] out = jrmKeccak.digestArray(200);

            System.out.println(out.length);

            String hexOut = new String(bytesToHex(out));

            System.out.println(hexOut);



//        try {
//            KeccakJ keccakJ = new KeccakJ(message.getBytes(StandardCharsets.UTF_8));
//
//            byte[] out = keccakJ.out();
//
//            System.out.println(out.length);
//
//            String hexOut = new String(Hex.encode(out));
//
//            System.out.println(hexOut);
//
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }


//        Jeok70Keccak jeok70Keccak = new Jeok70Keccak(1600);
//
//        String out = jeok70Keccak.getHash(message);
//
//        System.out.println(out);


    }

    /* s must be an even-length string. */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
