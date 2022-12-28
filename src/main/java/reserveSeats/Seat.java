package reserveSeats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat implements Comparable<Seat> {
    private final String seatNumber;
    private boolean reserved = false;

    public Seat(String seatNumber){
        this.seatNumber = seatNumber;
    }


    public boolean reserve(){
        if(!this.reserved){
            this.reserved = true;
            System.out.println("Seat " + seatNumber + " reserved");
            return true;
        } else{
            return false;
        }
    }

    public boolean cancel(){
        if(this.reserved){
            this.reserved = false;
            System.out.println("Reservation of seat " + seatNumber + " is cancelled");
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }
}
