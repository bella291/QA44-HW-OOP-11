package SmartHome;

public class Radio {


    private int maxStation;
    private int minStation;
    private int currentStation;
    static final int maxVolume = 100;
    static final int minVolume = 0;
    private int currentVolume;


    public Radio() {
        this.minStation = 0;
        this.maxStation = 9;
    }

    public Radio(int counterStation) {
        this.maxStation = counterStation - 1;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation || currentStation > maxStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void setNextStation() {
        if (currentStation == maxStation) {
            this.currentStation = minStation;
        } else {
            this.currentStation = currentStation + 1;
        }
    }

    public void setPrevStation() {
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

    public void setVolumeUp() {
        if (currentVolume == maxVolume) {
            return;
        }
        this.currentVolume = currentVolume + 1;
    }

    public void setVolumeDown() {
        if (currentVolume == minVolume) {
            return;
        }
        this.currentVolume = currentVolume - 1;
    }
}