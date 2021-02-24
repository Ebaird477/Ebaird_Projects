import java.util.Arrays;

public class Insertion {
	



	public static int[] insertionSort(int numbers[]) {
		int count = 0;
		for(int ac = 0; ac < numbers.length; ac++) {
		for(int i= 0; i< numbers.length; i++) {
			int a = i-1;
			while(a != -1){
				if(numbers[a] > numbers[i]) {

					int differenceInSpots = i - a;
					for(int x = 0; x < differenceInSpots;x++) {
						int usurper = numbers[i];
						int incumbent = numbers[i-1];
						int start = i;
						int end = i-1;
						numbers[start] = incumbent;
						numbers[end] = usurper;
					}
				}

				a--;
			}
		}
		}
		
		
	return numbers;	
	}
	
	
	
	public static void main(String[] args) {
		int[] test = {1, 7, 3, 5, 4, 6, 2};
		System.out.println(Arrays.toString(test));
		System.out.println("---------------------------");

		System.out.print(Arrays.toString(insertionSort(test)));
	}
	
		
	}
