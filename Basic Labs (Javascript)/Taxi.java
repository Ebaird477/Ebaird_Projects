public class Taxi {
		
    private double rate;
    private int capacity;

	public Taxi() { // NO-ARGUMENT CONSTRUCTOR
        this.rate = 0.0;
        this.capacity = 0;

	}
	
	public Taxi(double rate, int capacity) {

        this.rate = rate;
        this.capacity = capacity;

	}
	
	public double calculateFare(int passengersLeaving, int durationOfRide) {

        double ans = 0.0;

        ans = this.rate * durationOfRide;

        return ans;

	}
	
	public boolean pickUp(int passengersLoading) {

        if(passengersLoading <= this.capacity){
            return true;
        }
        else{
            return false;
        }
	}

}