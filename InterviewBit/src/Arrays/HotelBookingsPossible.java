package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * A hotel manager has to process N advance bookings of
 * rooms for the next season. His hotel has K rooms.
 * Bookings contain an arrival date and a departure date.
 * He wants to find out whether there are enough rooms
 * in the hotel to satisfy the demand.
 *
 * Write a program that solves this problem in time O(N log N).
 *
 * Input:
 * -----------------------------------------------------
 *
 * First list for arrival time of booking.
 * Second list for departure time of booking.
 * Third is K which denotes count of rooms.
 *
 * Output:
 *-----------------------------------------------------
 *
 * A boolean which tells whether its possible to make a booking.
 * Return 0/1 for C programs.
 * O -> No there are not enough rooms for N booking.
 * 1 -> Yes there are enough rooms for N booking.
 * Example :
 *
 * Input :
 * Arrivals :   [1 3 5]
 * Departures : [2 6 8]
 * K : 1
 *
 * Return : False / 0
 *
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBookingsPossible {

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(1);a.add(3);a.add(5);
        List<Integer> b = new ArrayList<>();
        b.add(2);b.add(4);b.add(6);
        System.out.println(checkBookingsPossible(a, b, 1));
    }

    public static boolean checkBookingsPossible(List<Integer> arrive, List<Integer> depart, int k){

        Collections.sort(arrive);
        Collections.sort(depart);

        int n = arrive.size();
        int res = 1, max = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrive.get(i) < depart.get(j)) {
                ++res;
                if (res > max) {
                    max = res;
                }
                ++i;
            }
            else {
                --res;
                ++j;
            }
        }

        return k >= max;
    }

}
