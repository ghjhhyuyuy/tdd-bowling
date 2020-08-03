package twu;

import java.util.Arrays;

/**
 * Created by wzw on 2020/8/3
 *
 * @author wzw
 */
public class Frame {
    private int throwNumber;
    private int[] pinNumber;

    Frame(int throwNumber, int[] pinNumber) {
        this.throwNumber = throwNumber;
        this.pinNumber = pinNumber;
    }
    public int sumPinNumber(){
        return Arrays.stream(pinNumber).sum();
    }

    public int getThrowNumber() {
        return throwNumber;
    }

    public void setThrowNumber(int throwNumber) {
        this.throwNumber = throwNumber;
    }

    public int[] getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int[] pinNumber) {
        this.pinNumber = pinNumber;
    }
}
