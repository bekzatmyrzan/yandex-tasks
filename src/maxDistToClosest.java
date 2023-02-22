public class maxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int first = -1;
        int second = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1)  {
                if (first == -1) {
                    first = i;
                    maxDistance = i;
                } else {
                    second = i;

                    maxDistance = Math.max(maxDistance, (second - first)/2);
                    first = i;
                }
            }
        }
        if (second == -1 || first == second) {
            maxDistance = Math.max(maxDistance, seats.length - first - 1);
        }
        return maxDistance;
    }
}
