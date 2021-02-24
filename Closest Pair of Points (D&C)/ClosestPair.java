import java.util.*;

/*
* Implement the "dc_closest" method below to match the closest pair of points algorithm discussed in class.
* Your algorithm must be divide an conquer, with the base case, divide, conquer, and combine steps clearly marked.
* Your implementation must have nlogn running time.
* There is an accompanying file provided to help you verify correctness and running time of your implementation
* You may submit only this file. Do not leave any lingering print statements in any methods.
* Do not import any additional packages.
*/

public class ClosestPair {

    public static double distance(final Point p1, final Point p2) {
        // a function to compute the distance between two points
        // Do not modify this function
        final double deltax = p1.x - p2.x;
        final double deltay = p1.y - p2.y;
        return Math.sqrt(deltax * deltax + deltay * deltay);
    }

    public static Pair<Double, Point[]> quadratic_closest(final Point[] points) {
        // A quadratic procedure for finding closest pair of points. Use this for timing
        // comparison.
        // This can also serve as your base case if you'd like.
        // It returns a pair of values: the distance of the closest pair and the list of
        // points re-sorted by y.
        // Do not modify this function
        double closest = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            final Point p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                final Point p2 = points[j];
                final double d = distance(p1, p2);
                if (d < closest) {
                    closest = d;
                }
            }
        }
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(final Point p1, final Point p2) {
                if (p1.y != p2.y) {
                    return p1.y - p2.y < 0 ? -1 : 1;
                }
                return p1.x - p2.x < 0 ? -1 : 1;
            }
        });
        return new Pair<Double, Point[]>(closest, points);
    }

    private static Point[] get_runway(final Point[] y_sorted, final double median_x, final double delta) {
        // A procedure to extract all points in the runway
        // I found this function to be useful, but you're not required to implement and
        // use it if you don't want to
        final ArrayList<Point> runway = new ArrayList<Point>();
        
        double far_right = median_x + delta;
        double far_left = median_x - delta;
        for(int index = 0; index < y_sorted.length ; index ++){
            if(y_sorted[index].x <= far_right && y_sorted[index].x >= far_left){
                runway.add(y_sorted[index]);
            }
        }
        return runway.toArray(new Point[runway.size()]);
    }

    private static Point[] merge(final Point[] left, final Point[] right) {
        // A procedure to merge the points by y value
        // You'll almost certainly need to use this one, but it's ok if you don't use
        // it.
        final Point[] merged = new Point[left.length + right.length];

        int leftSpot = 0;
        int rightSpot = 0;
        int mergeSpot = 0;

        while(leftSpot < left.length && rightSpot < right.length){

            if(left[leftSpot].y <= right[rightSpot].y){
                merged[mergeSpot] = left[leftSpot];
                leftSpot += 1;
                mergeSpot += 1;
            }

            else if(left[leftSpot].y > right[rightSpot].y){
                merged[mergeSpot] = right[rightSpot];
                rightSpot += 1;
                mergeSpot += 1;
            }

        }
        
        while(leftSpot < left.length){
            merged[mergeSpot] = left[leftSpot];
            leftSpot += 1;
            mergeSpot += 1;
        }

        while(rightSpot < right.length){
            merged[mergeSpot] = right[rightSpot];
            rightSpot += 1;
            mergeSpot += 1;
        }
        return merged;
    }

    public static Pair<Double, Point[]> dc_closest(final Point[] x_sorted) {
        // The divide and conquer closest pair of points algorithm
        // The input is a list of points sorted by x value
        // The output is a pair comprised of the closest pair of points from among the
        // given points, and the given points re-sorted by y
        // Your assignment is to implement this function. It's required that your
        // algorithm runs in nlogn time, and that it follow the divide and conquer
        // format.

        // BASE CASE
        // You'll need to have a base case. I've provided one, but you may change it if
        // you prefer something else
        // We will not run your code on any test cases with fewer than 2 points.
        if (x_sorted.length < 2) {
            return quadratic_closest(x_sorted);
        }

        // DIVIDE STEP
        // For the divide step, split the list of points into two sub-lists of length
        // n/2
        // Save the median x coordinate, you'll need that later for COMBINE
        Point medianPoint = x_sorted[((int)(x_sorted.length)/ 2)];
        Double median = medianPoint.x;
        int medianInt = ((int)(x_sorted.length)/ 2);

        Point[] left = new Point[medianInt];
        Point[] right = new Point[ medianInt];        

        int indexer = 0;
        for(int x = 0; x < medianInt; x++) {
            left[x] = x_sorted[x];
            indexer += 1;
        }
        for (int c = 0; c < medianInt; c++) {
            right[c] = x_sorted[indexer];
            indexer += 1;

        }

        // CONQUER STEP
        // For this step, recursively solve closest pair of points on the two halves
        // You'll need both the distance returned as well as the points sorted by y
        // value
        final Pair<Double, Point[]> leftWing = dc_closest(left);
        final Pair<Double, Point[]> rightWing = dc_closest(right);
        double distance = Math.min(leftWing.getKey(), rightWing.getKey());
        // COMBINE STEP
        // For this step, you'll need to merge points by y value, identify the points in
        // the "runway", and find the closest pair which crosses the divide

        Point[] finalSorted = merge(left, right);
        Point[] runArray = get_runway(finalSorted, median, distance);
        for(int index = 0; index < runArray.length ; index ++){
        int limit = 1;
            while(limit < 15 && (index + limit) < runArray.length){
                Double newDis = distance(runArray[index], runArray[index + limit]);
                if( newDis < distance){
                    distance = newDis;
                }
                limit += 1;
            }
        }


        // RETURN VALUE
        // The return value will be the distance of the closest pair found and all
        // points sorted by y value
        final double delta = distance;
        final Point[] y_sorted = new Point[0];
        return new Pair<Double, Point[]>(delta, y_sorted);
    }

    public static double closest_pair(final Point[] points) {
        // Helper function to hide the recursion since the recursive function needs a second return value
        // All this does is sort the points by x, invoke the D&C algorithm, and return only the distance
        Arrays.sort(points);
        final Pair<Double, Point[]> ret_val = dc_closest(points);
        return ret_val.getKey();
    }

    public static void main(final String[]args){
        final Point[] points = {new Point(1.0, 2.1), new Point(2.0, 2.0), new Point(3.0, 3.0), new Point(4.0, 4.0), new Point(6.0, 5.0), new Point(5.0, 6.0)};
        System.out.println(closest_pair(points)); // example invocation of D&C algorithm
        final Pair<Double, Point[]> return_value = quadratic_closest(points); // example invocation of quadratic algorithm
        final double distance = return_value.getKey(); // to get the first of the two return values, call getKey() on the pair returned
        final Point[] y_sorted = return_value.getValue(); // to get the second of the two return values, call getValue() on the pair returned
        System.out.println(distance);
    }

}
