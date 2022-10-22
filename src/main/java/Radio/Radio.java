package Radio;

public class Radio {
    static final int maxStation = 9;//max, конечная радиостанция
    static final int minStation = 0;//min, начальная радиостанция
    private int currentStation;// текущая радиостанция
    static final int maxVolume = 10;// max громкость
    static final int minVolume = 0;// min громкость
    private int currentVolume; // текущая громоксть

    public int getCurrentStation() {
        return currentStation;
    } //получить текущую радиостанцию. Возврат текущей радиостанции

    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }

    public void setSelectStation(int selectStation) { //выбор номера станции напрямую.
        // Выбранная станция будет всегда находиться в обозначенном диапазоне. Если не применить сеттер такого вида
        // пользователь может установить любое значение.
        if (selectStation < minStation || selectStation > maxStation) {
            return;
        }
        this.currentStation = selectStation;
    }

    public void setNextStation() { //след радиостанция.  Принцып закольцованной конвейрной ленты которая движется по кругу.
        // В данном случае в прямом направлении.
        if (currentStation == maxStation) {
            this.currentStation = minStation;
        } else {
            this.currentStation = currentStation + 1;
        }
    }

    public void setPrevStation() { //пред радиостанция. Принцып закольцованной конвейронй ленты которая движется по кругу.
        // В данном случае в обратном направлении.
        if (currentStation == minStation) {
            this.currentStation = maxStation;
        } else {
            this.currentStation = currentStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void setVolumeUp() { //повышение громкости
        if (currentVolume == maxVolume) {
            return;
        }
        this.currentVolume = currentVolume + 1;
    }

    public void setVolumeDown() { //понижение громкости
        if (currentVolume == minVolume) {
            return;
        }
        this.currentVolume = currentVolume - 1;
    }

}
