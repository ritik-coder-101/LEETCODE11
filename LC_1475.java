// 1475. Final Prices With a Special Discount in a Shop -{E};

// You are given an integer array prices where prices[i] is the price of the ith item in a shop.

// There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

// Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.

class Solution {
    public int[] finalPrices(int[] prices) {
        // int[] res=new int[prices.length];
        // Arrays.fill(res,1001);

        // for (int i=0;i<prices.length-1;i++) {
        //     for (int j=i+1;j<prices.length;j++) {
        //         if (prices[i] >= prices[j]) {
        //             System.out.println(prices[i]+": "+prices[j]);
        //             res[i]=prices[i]-prices[j];
        //             break;
        //         }
        //     }
        //     if (res[i] == 1001) res[i]=prices[i];
        // }
        // res[prices.length-1]=prices[prices.length-1];
        // return res;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<prices.length;i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -=prices[i];
            }
            stack.push(i);
        }
        
        return prices;
    }
}