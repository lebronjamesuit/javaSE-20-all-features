import java.io.BufferedReader;
import java.io.InputStreamReader;

// Silly way to implement, native way
public class BuyerConnections {

        public static void main(String args[] ) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int initialCount = Integer.parseInt(br.readLine());
            char[][] buys = readBuys(br, initialCount);

            int inferredCount = transitiveBuysCount(initialCount, buys);
            System.out.println(inferredCount);
        }

        static char[][] readBuys(BufferedReader br, int count) throws Exception {
            char[][] buys = new char[count][2];
            for (int i = 0; i < count; i++) {
                String[] line = br.readLine().split(" ");
                buys[i][0] = line[0].charAt(0);
                buys[i][1] = line[1].charAt(0);
            }
            return buys;
        }

        static int transitiveBuysCount(int initialCount, char[][] buys) {
            // implement your solution
            // Right buyer  buys[row][1]
            // Left  buyer  buys[i][0]

            int countLink = 0;
            for (int row=0; row< buys.length; row++){
                char rightBuyer = buys[row][1];
                for (int i = 0; i <buys.length ; i++) {
                    if (rightBuyer == buys[i][0]){
                       countLink++;
                    }
                }
            }
            countLink-- ;
            return countLink;  // minus 1 time because loop duplicate row once.
        }

}
