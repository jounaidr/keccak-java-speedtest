package KeccakJ;

import com.github.aelstad.keccakj.core.AbstractKeccakMessageDigest;

public final class CustomInitializer extends AbstractKeccakMessageDigest {

    private final static byte DOMAIN_PADDING = 2;
    private final static int DOMMAIN_PADDING_LENGTH = 2;

    public CustomInitializer() {
        super("SHA3-256", 1600, 200 / 8, DOMAIN_PADDING, DOMMAIN_PADDING_LENGTH);
    }

}
