import BobulousKeccak.BobulousKeccak;
import Jeok70Keccak.Jeok70Keccak;
import KeccakJ.KeccakJ;
import jrmelshaKeccak.JrmKeccak;
import org.bouncycastle.util.encoders.Hex;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class KeccakRunner {
    public static void main(String[] args) {
        System.out.println("Sandbox for testing out different keccak implementations!!!");

        String message;

        message = "poop";

        //25
        //fa52390715ce6d0e7fc7966639f9840aaf95331c4b389b0a40

        BobulousKeccak keccak = new BobulousKeccak(message.getBytes(StandardCharsets.UTF_8));

        byte[] out = keccak.returnHash();

            System.out.println(out.length);

            String hexOut = new String(Hex.encode(out));

            System.out.println(hexOut);



        //25
        //458e4ddd8fd7a4c55cf2ab5651d1b0de4e3bb51bba675a509b

//        JrmKeccak jrmKeccak = new JrmKeccak(512);
//
//        jrmKeccak.update(message.getBytes(StandardCharsets.UTF_8));
//
//        byte[] out = jrmKeccak.digestArray(25);
//
//            System.out.println(out.length);
//
//            String hexOut = new String(Hex.encode(out));
//
//            System.out.println(hexOut);



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
}
