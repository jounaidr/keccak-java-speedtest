# keccak-java-speedtest
A repo to test the speed and performance of different [keccak1600](https://github.com/monero-project/monero/blob/26cae8f4f150594b6c14fe56be08365dae1b1c50/src/crypto/keccak.c#L131) Java implementations (to be used for a Java native CryptoNight implementation).
As described in the [CryptoNote standards](https://cryptonote.org/cns/cns008.txt) (and also implemented in Monero), keccak1600 is a special case [keccak](https://keccak.team/keccak_specs_summary.html) function with the following parameters: b = 1600 and c = 512.
The produced hash is used in the first step of the CryptoNight algorithm.

Please note this is a sandbox style repo for the purposes of testing and learning different Java keccak implementations, 
therefore the solutions provided here are very 'hacky', and the code/repo structure is very messy, please refer to [JCryptoNight](https://github.com/jounaidr/JCryptoNight)
for the finished and optimised solution.

---

### Working solutions

The two solutions tested and verified are: [Bobulous's solution](https://gitlab.com/Bobulous/Cryptography) and [jrmelsha's solution](https://gitlab.com/Bobulous/Cryptography).

As mentioned before, simple hacks have been used to get the functions working for keccak1600, these hacks can be found [here](https://github.com/jounaidr/keccak-java-speedtest/blob/546d257a291dbb4ac0a30cce01d00281b7663dae/src/main/java/uk/org/bobulous/java/crypto/keccak/KeccakState.java#L168) for Bobulous's solution, and [here](https://github.com/jounaidr/keccak-java-speedtest/blob/546d257a291dbb4ac0a30cce01d00281b7663dae/src/main/java/jrmelshaKeccak/JrmKeccak.java#L305) for Jrmelsha's solution.

---

### Performance report

The [test suite](https://github.com/jounaidr/keccak-java-speedtest/blob/main/src/test/java/KeccakSpeedTest.java) 
I used involved hashing 5 different strings 1,000,000 times each for a total of 5,000,000 hashes, for which each test case was ran 5 times (to calculate an average).
The tests were conducted on an [Intel Core i7 i7-10750H](https://ark.intel.com/content/www/us/en/ark/products/201837/intel-core-i7-10750h-processor-12m-cache-up-to-5-00-ghz.html) and the raw results can be found in the [test suite](https://github.com/jounaidr/keccak-java-speedtest/blob/main/src/test/java/KeccakSpeedTest.java).
The results are as follows: 
- **Bobulous's solution:** 10061.4ms average execution time, 17.4% average cpu usage.
- **jrmelsha's solution:** 2500.2ms average execution time, 17.6% average cpu usage.

---

### Solution comparison

|**Bobulous's solution**|**jrmelsha's solution**|
|---|---|
|Much better documentation<br>and sufficiently tested|Around 4x faster|
|Last commit (as of 14/10/2020)<br>was at: Jun 10, 2017|Last commit (as of 14/10/2020)<br>was at: Jan 12, 2020|
| |Single class solution<br>will be much easier to<br>implement and optimise|

For the [algorithm](https://github.com/jounaidr/JCryptoNight) I wish to implement, I believe jrmelsha's solution to be the best solution for the reasons stated above.

---

### Acknowledgments

I also attempted to also 'hack' the following algorithms, however (for specific reasons) I found their solutions not worth testing and implementing...

- [KeccakJ](https://github.com/aelstad/keccakj)
- [jeok70's solution](https://gist.github.com/jeok70/ff62b90e703a054d4df4)
