import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.example.Radio;


public class RadioTest {
    @Test
    public void setCurrentStation_withinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_outsideRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation()); // По условию, станция должна быть 0, если значение вне диапазона
    }

    @Test
    public void increaseVolume_withinRange() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolume_maxVolumeReached() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }
    @Test
    public void decreaseVolume_withinRange() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.decreaseVolume();
        assertEquals(4, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolume_minVolumeReached() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume()); // Ожидаем, что уровень громкости останется 0, так как не может быть меньше
    }

    @Test
    public void nextStation_withinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void nextStation_maxStationReached() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // Если текущая станция 9, следующая станция должна быть 0
    }

    @Test
    public void prevStation_withinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void prevStation_minStationReached() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation()); // Если текущая станция 0, предыдущая станция должна быть 9
    }

}
