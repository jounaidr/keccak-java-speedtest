package BobulousKeccak;

import uk.org.bobulous.java.crypto.*;
import uk.org.bobulous.java.crypto.keccak.KeccakSponge;

public class BobulousKeccak {
    byte[] in;
    KeccakSponge spongeFunction = new KeccakSponge(1088, 512, "", 200);

    public BobulousKeccak(byte[] in) {
        this.in = in;
    }

    public byte[] returnHash(){
        byte[] hash = spongeFunction.apply(5, in);
        return hash;
    }
}
