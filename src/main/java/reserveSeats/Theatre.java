package collectionsFrameWork;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();


    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for(char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = null;
        for(Seat seat: seats){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestedSeat = seat;
                break;
            }
        }
        if(requestedSeat == null){
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();
    }

    //for testing
    public void getSeats(){
        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }



}
