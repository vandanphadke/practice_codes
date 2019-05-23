public class GasStations {
    public static void main(String[] args){
        int[] cost = {};
        int[] gas = {};




    }

    private int getStartingIndex(int[] gas, int[] cost){
        int startIndex = 0;
        int n = gas.length;
        while (startIndex < n){
            int currentIndex = startIndex;
            int currentGas = 0;

            while(currentGas >= 0 && currentIndex != (startIndex - 1) % n){
                currentGas += (gas[currentIndex % n] - cost[currentIndex % n]);
                ++currentIndex;
            }

            if (currentIndex == (startIndex - 1) % n){
                return startIndex;
            }
            else {
                startIndex = currentIndex;
            }

        }

        return -1;
    }


}
