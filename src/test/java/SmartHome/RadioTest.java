package SmartHome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 5; 5",
            "invalid value analysis 1; -9; 0",
            "Invalid value analysis 2; 25; 0",
            "Invalid value analysis 32; 11; 0",
            "Boundary value analysis 1; -1; 0",
            "Boundary value analysis 2; 0; 0",
            "Boundary value analysis 3; 1; 1",
            "Boundary value analysis 4; 8; 8",
            "Boundary value analysis 5; 9; 9",
            "Boundary value analysis 6; 10; 0",
    }, delimiter = ';')
    void setSelectStation(String nameTest, int inputSelectStation, int expectedStation) {
        Radio radio = new Radio();

        radio.setCurrentStation(inputSelectStation);
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 5; 6",
            "Boundary value analysis 1; 0; 1",
            "Boundary value analysis 2; 1; 2",
            "Boundary value analysis 3; 8; 9",
            "Boundary value analysis 4; 9; 0",
    }, delimiter = ';')
    void setNextStation(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.setNextStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 5; 4",
            "Boundary value analysis 1; 0; 9",
            "Boundary value analysis 2; 1; 0",
            "Boundary value analysis 3; 8; 7",
            "Boundary value analysis 4; 9; 8",
    }, delimiter = ';')
    void setPrevCurrentStation(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.setPrevStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "value analysis, 20 stations; 20; 15; 15",
    }, delimiter = ';')

    void setSelectStationCustomSetting(String nameTest, int counterStation, int inputSelectStation, int expectedStation) {
        //Radio radio = new Radio(); если применить конструктор с параметрами по дефолту, то будет ошибка так как ожидаемый резултат должен быть = 0
        Radio radio = new Radio(counterStation); // корректный конструктор, который принимает любое значение о кол-ве станций от ползователя.
        // В данном случае создали радио с 20 станциями (номер макс: кол-во -1 = 19). Выбрали 15-ую, Её и ожидаем получить.
        radio.setCurrentStation(inputSelectStation);
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 60; 61",
            "Boundary value analysis 1; 0; 1",
            "Boundary value analysis 2; 1; 2",
            "Boundary value analysis 3; 99; 100",
            "Boundary value analysis 4; 100; 100",
    }, delimiter = ';')
    void setVolumeUp(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.setVolumeUp();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 60; 59",
            "Boundary value analysis 1; 0; 0",
            "Boundary value analysis 2; 1; 0",
            "Boundary value analysis 3; 99; 98",
            "Boundary value analysis 4; 100; 99",
    }, delimiter = ';')
    void setVolumeDown(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.setVolumeDown();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }}