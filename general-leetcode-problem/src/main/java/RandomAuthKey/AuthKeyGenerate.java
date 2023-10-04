package RandomAuthKey;

import java.util.Random;

public class AuthKeyGenerate {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.println(getRandomAuthKey());

        }
    }

    private static long getRandomAuthKey() {
        Random rn = new Random();
        long rndKey = 0;
        while(rndKey < 1000000000.0) {
            rn.setSeed(System.currentTimeMillis());

            rndKey = rn.nextLong();
            rndKey = Math.abs(rndKey);

            rndKey = (long)Math.floor(rndKey / 1000000000.0);
        }
        return rndKey;
    }
}
