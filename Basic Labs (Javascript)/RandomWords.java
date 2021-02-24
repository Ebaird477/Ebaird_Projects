import java.util.Random;

public class RandomWords {

	public static int hashFunction(String str, int tablesize) {
		int ans = 0;
		for(int x = 0; x < str.length(); x++) {
			
			char character = str.charAt(x);
			int a = (int) character;

			ans = ans + a;
		}
		return ans % tablesize;

	}
	public static void main(String[] args) {
		int a = 0;
		String[] myHashTable = new String[500];
		String[] xStrings = generateRandomWords(500);
		boolean isPresentAlready = false;

		for(int x = 0; x < xStrings.length; x++) {
			String tString = xStrings[x];
			int result = hashFunction(tString, 500);
			
			int counter = 0;

			while(!(myHashTable[result] == null) && counter < 500) {
				result++;
				a++;
				counter++;
				System.out.println("Collision Count: "+a+".");
				
				if(result == 500) {
					result = 0;
				}

			}



			myHashTable[result] = tString;




		}



		System.out.println("Done!");




	}

	//A static method that takes in the number or words you would like in your array of 
	//random words.  Each word is between 3 and 10 characters in length and contain only
	//lower case letters.  
	public static String[] generateRandomWords(int numberOfWords)
	{
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for(int i = 0; i < numberOfWords; i++)
		{
			char[] word = new char[random.nextInt(8)+3]; // Words of length 3 through 10. (Because 1 and 2 letter words are boring.)
			for(int j = 0; j < word.length; j++)
			{
				word[j] = (char)('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}

}