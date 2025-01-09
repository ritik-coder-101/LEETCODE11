// 1109. Corporate Flight Bookings -{M}

// There are n flights that are labeled from 1 to n.

// You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
// Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res=new int[n+1];

        for (int[] i : bookings) {
            res[i[0]-1]+=i[2];
            res[i[1]] -=i[2];
        }

        int[] arr=new int[n];
        int count=0;

        for (int i=0;i<n;i++) {
            count+=res[i];
            arr[i]=count;
        }

        return arr;
    }
}