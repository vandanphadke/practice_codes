/**
 * Q: Koko loves to eat bananas.  There are N piles of bananas,
 * the i-th pile has piles[i] bananas.
 * The guards have gone and will come back in H hours.
 *
 * Koko can decide her bananas-per-hour eating speed of K.
 * Each hour, she chooses some pile of bananas, and eats K bananas
 * from that pile.  If the pile has less than K bananas,
 * she eats all of them instead, and won't eat any more
 * bananas during this hour.
 *
 * Koko likes to eat slowly, but still wants to finish
 * eating all the bananas before the guards come back.
 *
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 *
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int n = piles.length;

        for (int i = 0; i < n; ++i){
            if (piles[i] > max)
                max = piles[i];

            sum += piles[i];
        }

        int rangeMin = (int)Math.ceil(sum / H);
        int rangeMax = max;
        return modifiedBS(piles, rangeMin, rangeMax, H);

    }

    public int modifiedBS(int[] piles, int low, int high, int hours){
        int min = low;
        int max = high;

        while (min < max){
            int mid = min + (max - min)/2;
            if (canEat(piles, mid, hours))
                max = mid;
            else
                min = mid + 1;
        }

        return min;
    }

    public boolean canEat(int[] bananas, int speed, int hours){
        int time = 0;
        for (int p: bananas)
            time += (p-1) / speed + 1;
        return time <= hours;
    }
}
