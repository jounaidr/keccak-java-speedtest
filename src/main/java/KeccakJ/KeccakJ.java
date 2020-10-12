package KeccakJ;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class KeccakJ {
    MessageDigest md;

    public KeccakJ(byte[] in) throws NoSuchProviderException, NoSuchAlgorithmException {
        md = new CustomInitializer();

        md.update(in);
    }

    public byte[] out(){
        return md.digest();
    }

}
