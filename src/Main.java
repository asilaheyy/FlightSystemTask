import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        Set <Flight> flights = Set.of(
                new Flight(LocalDate.of(2023,10,27),LocalTime.of(16,15), City.LISBON, City.LONDON),
                new Flight(LocalDate.of(2023,10,01),LocalTime.of(17,30), City.MOSCOW, City.PRAGUE),
                new Flight(LocalDate.of(2023,9,15), LocalTime.of(9,45), City.MOSCOW, City.PARIS)
        );

        //вывод всех рейсов
        flights.stream().forEach(System.out::println);

        //фильтрация по дате
        flights.stream().filter( d -> d.getDate().isAfter(LocalDate.of(2023,10,01)))
                .collect(Collectors.toList()).forEach(System.out::println);

        //фильтрация по времени
        flights.stream().filter(t -> t.getTime().isAfter(LocalTime.of(16,30)))
                .collect(Collectors.toList()).forEach(System.out::println);

        }





}


