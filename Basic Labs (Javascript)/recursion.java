
public class recursion {

	public static void main(String[] args) 
	{
		int[] values = {19, 12, 13, 14, 17, 18, 16, 14, 11};
		int[] maxMinResults = maxMin(values, 0, values.length - 1);
		System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
	}

	/*  maxMin() - Return an array containing the minimum and maximum values of the input array.
	 * 	@param list: an array of ints as input
	 * 	@param first: the first index of the list (for recursion)
	 * 	@param last: the last index of the list (for recursion)
	 * 	
	 * 	Identify a base case, and work it out so that the array returns the min and max values.
	 * 	Then, identify what the method does to recursively arrive at the base case.
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	public static int[] maxMin(int[] list, int first, int last)
	{

		int[] fin = new int[2];
		int min = list[first];
		int max = list[last];


		if(list.length == 2) {
			fin[0]= min;
			fin[1]= max;
			return fin;
		}
		else {
			System.out.println("Preflip Min: "+list[first]);
			System.out.println("Preflip Max: "+list[last]);
			
			

			System.out.println("Preflip Comparison: "+list[first]+" > "+list[last]);
			if(min > max) {
				list[last] = min;
				list[first] = max;
			}
			
			
			
			System.out.println("Postflip Min: "+list[first]);
			System.out.println("Postflip Max: "+list[last]);
			
			
			int pmin = list[first+1];
			int pmax = list[last-1];
			if(pmin > pmax) {
				list[first+1] = pmax;
				list[last-1] = pmin;

			}
			if(list[first] < list[first+1]) {
				list[first+1] = list[first];
			}
			if(list[last] > list[last-1]) {
				list[last-1] = list[last];
			}
			System.out.println("New Min: "+list[first+1]);
			System.out.println("New Max: "+list[last-1]);
			System.out.println("-----------------------");
			
			if(first+ 1 == last -1) {
				fin[0]= min;
				fin[1]= max;
				return fin;
			}


			return maxMin(list, first+1, last-1);
		}

	}
}
