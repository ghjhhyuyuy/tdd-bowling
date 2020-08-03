package twu;

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
    public int getSumPinNumber(){
        int sum = 0;
        for (int i = 0; i < pinNumber.length; i++) {
            sum += pinNumber[i];
        }
        return sum;
    }
}
