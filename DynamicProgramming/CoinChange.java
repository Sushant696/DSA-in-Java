package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    static int coinChange(int coins[], int amount) {

        if (amount < 1) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Fill with MAX_VALUE initially
        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin = 0; coin < coins.length; coin++) {
                if (i - coins[coin] >= 0 && dp[i - coins[coin]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[coin]] + 1);
                }
            }
        }
        // if it's max value then it's combo cannot be made from the avaliable coins
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
