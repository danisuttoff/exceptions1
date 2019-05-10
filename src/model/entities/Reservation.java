package model.entities;
//https://github.com/acenelio/exceptions1-java


import model.exception.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    // é statico para que não seja estanciado um novo simpleDateFormat
// para cada objeto reservation que a aplicação tiver, iremos precisar de apenas um.
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
        if(!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {

        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {

        return checkIn;
    }



    public Date getCheckOut() {
        return checkOut;
    }
    //calcula duração em dias com base nas duas datas
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();// pega a diferença em milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }
    public void updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if(checkIn.before(now) ||checkOut.before(now)){
            //classe de exceção para erro de argumento
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }
    @Override
    public String toString(){
        return "Room: "
                + roomNumber
                +", check-in: "
                + sdf.format(checkIn)
                +", check-out: "
                +sdf.format(checkOut)
                +", "
                + duration()
                +" nights ";

    }



}
