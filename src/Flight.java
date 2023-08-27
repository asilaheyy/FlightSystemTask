import java.time.LocalDate;
import java.time.LocalTime;

/** Класс модели авиаперелета со свойствами */
public class Flight {

    /** Свойства перелета : уникальный ID рейса, дата и время вылета, локация отправления, локация пребывания*/
    int flightNumber = 1394;
    private LocalDate date;
    private LocalTime time;
    private City departureLocation;
    private City arrivalDestination;

    /** Конструктор перелета. В конструкторе исполъзуются проверки на дату и время, а так же на локации отправления и пребывания*/
    public Flight(LocalDate date, LocalTime time, City departureLocation, City arrivalDestination) {
        flightNumber++;
        this.date = date;
        this.time = time;
        if (date.isBefore(LocalDate.now())|| date.equals(LocalDate.now()) && time.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("Creation date cannot be before current date!");
        }
        this.departureLocation = departureLocation;
        if (departureLocation.toString().equals(arrivalDestination.toString())) {
            throw new IllegalArgumentException("Departure and destination cannot be equal!");
        }
        this.arrivalDestination = arrivalDestination;
        if (arrivalDestination.toString().equals(departureLocation.toString())) {
            throw new IllegalArgumentException("Departure and destination cannot be equal!");
        }
    }

/** Геттеры и сеттеры */
    public City getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(City departureLocation) {
        this.departureLocation = departureLocation;
    }

    public City getArrivalDestination() {
        return arrivalDestination;
    }

    public void setArrivalDestination(City arrivalDestination) {
        this.arrivalDestination = arrivalDestination;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime(){
        return time;
    }

/** Метод для правильного вывода текста */
    @Override
    public String toString() {
        return "Flight " + flightNumber +
                " " + date + " at "+time+
                " from " + departureLocation +
                " to " + arrivalDestination;


    }
}
