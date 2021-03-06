import BobulousKeccak.BobulousKeccak;
import jrmelshaKeccak.JrmKeccak;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;
import uk.org.bobulous.java.crypto.keccak.KeccakSponge;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeccakSpeedTest {
    List<String> inputData = Arrays
            .asList("This is a test",
                    "",
                    "oioi im brit-ish",
                    "abc",
                    "x123!$$£*^(%)$$$$");

    List<String> validHashes = Arrays
            .asList("93b90fab55adf4e98787d33a38e71106e8c016f1a124dfc784f3cca4d938b1af67ddb7b96d09cbf61a34304fe8c63bb2ebc78902842fdc97e8b9ada086375818405e91deec2a0478578825373af7ea642d2c64fb5e6eb96ef1f6e04a7ae92d0de8199a4971070aa2cc3d5394c2eed3b5071c9c858b3b1a7d4dfd8a7ed491122d0fd38af56a96397cc69e455c1f7a167d4e8305dac7144d7d5d81e557d619cf14e9ff75c1d1e34f62c2c40d4763785786f6e51fe8869a80732159cebb9fd17b186e3e25c53b46d395",
                    "c5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a4703dbb9a2cd87ca974b9a2b0ec61119bcb5cedf9c0c411221f6141a25f17c60d82d24680abbcbfba815b762b24b751d5b1e85325ba5e6df23c10725bfe986ace3ba2d24535a79f7dbabb153bb0d33c0dfa09cec712ebd7fe3b49a9194e859c82ebff11a645651a5d1b726be100f44641069fab7164e13487fe3609bbeebd88309cbaacb2a7ecb8e8de2145cf1db7623b16916d7210991b576bbe182362cf22fab7d7af9f77f71afea3",
                    "bc5ab69b5413fa5dbe8107615cf8f9c13f300e51424706f8e6a4b5572b374cc706bc5173e168d7a783adf6a8479ea70a21a3ce5390d35617f3a6b471b2a5908afd3a2352ca93c5a851b79e47c0f5117902974748d1e94e36658e64eba827c9ce3268658c0c65c1e9fa091a3965a0830d7c589cf01b7bd2ab8d95e0204f3cc9a918b6b988d0f0518294a408cea62c99f82b2085954a651db340b478ac5b312c79a1c8f9fde5134271a0c237a6fb5c62c916c09f892e5408e34c2cbe45a72ce51bb5999253aadc7668",
                    "4e03657aea45a94fc7d47ba826c8d667c0d1e6e33a64a036ec44f58fa12d6c45812c38ac1e15a2bb6f607d9fe9a52dfc15c481b4d951a12cfe3523ab24e5f204cdf89d2a07a02a58fcaea7e53986d12b8447d8e845b9c884aab18b55c1608e726660007b904bdf1dc05f2501c28b9a2a8b2b4af4509bdd934a81ec860cc02e161ea19ef61a108742f1ddcedcd878c4d68c8de5d60bc1b12e99d1c7aecb5dd6930403479dfa290a61d2c8d514f177a97ed540e8769f6f8650ceb7a9e7c96d1c899abd41cd6d5effda",
                    "f4c71996d78c0c834445428729e5cbf410e18d4af9442169f072145803ca0b548fd88a10bc52f42ef033f1a0dcf652170a889e61be3cf34ddc86ded08edcc4c5b407fb7f73aae89c0df3d0de79e2bf10037e8e834d86515ccd7048afc908f38eca8ad7748ae09240aded60a793dc737c6886300a5865e22cc93f80ec1a90b8944f7b76d992dc54bc61c5962b6720d9a69b830d1309e002d2f29b5146dbb87be4d90280b0dea7d23fe9879baed1ce7e78659755384037f61ff92786bcb4c60fece87e05f4bf0cbf10");

    @Test
    public void bobulousKeccakSpeedTest(){
        long totalTime = 0;
        KeccakSponge spongeFunction = new KeccakSponge(1088, 512, "", 1600);

        for (int i = 0; i < inputData.size(); i++) {
            for(int x = 0; x < 1000000; x++){ //calculate each hash 1,000,000 times each (5,000,000 in total)
                long startTime = System.currentTimeMillis(); //start timer
                //BobulousKeccak keccak = new BobulousKeccak(inputData.get(i).getBytes());
                //keccak.returnHash();

                spongeFunction.apply(inputData.get(i).getBytes().length * 8, inputData.get(i).getBytes());
                //assertEquals(validHashes.get(i),new String(Hex.encode(keccak.returnHash())));
                long endTime = System.currentTimeMillis();

                totalTime = totalTime + (endTime - startTime); //end timer
            }
        }
        System.out.println("Total time after 5,000,000 hashes for bobulousKeccak is: " + (totalTime) + " milliseconds");
        //TEST TIMES: 10055 10095 10066 9972 10119
        //CPU USAGE: 17% 18% 17% 17% 18%
    }

    @Test
    public void jrmKeccakSpeedTest(){
        long totalTime = 0;

        for (int i = 0; i < inputData.size(); i++) {
            for(int x = 0; x < 1; x++){ //calculate each hash 1,000,000 times each (5,000,000 in total)
                long startTime = System.currentTimeMillis(); //start timer
                JrmKeccak jrmKeccak = new JrmKeccak();
                jrmKeccak.update(inputData.get(i).getBytes());
                byte[] out = jrmKeccak.digestArray(200);
                assertEquals(validHashes.get(i),new String(Hex.encode(out)));
                long endTime = System.currentTimeMillis();

                totalTime = totalTime + (endTime - startTime); //end timer
            }
        }
        System.out.println("Total time after 5,000,000 hashes for jrmKeccak is: " + (totalTime) + " milliseconds");
        //TEST TIMES: 2497 2499 2506 2474 2525
        //CPU USAGE: 18% 18% 17% 17% 18%
    }

}