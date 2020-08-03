package twu;

import java.util.List; /**
 * Created by wzw on 2020/8/3
 *
 * @author wzw
 */
public class BowlingGame {
    public int score(List<Frame> frameList) throws Exception {
        if(frameList == null || frameList.isEmpty()){
            throw new Exception("input is wrong");
        }
        int score = 0;
        for (int i = 0; i < frameList.size() - 1; i++) {
            if(frameList.get(i).getThrowNumber() == 1){
                score += sumStrike(frameList,i);
            }else if(frameList.get(i).sumPinNumber() == 10){
                score += sumSpare(frameList,i);
            }else {
                score += frameList.get(i).sumPinNumber();
            }
        }
        score += frameList.get(frameList.size() - 1).sumPinNumber();
        return score;
    }

    private int sumSpare(List<Frame> frameList, int index) {
        return frameList.get(index).sumPinNumber() + frameList.get(index + 1).getPinNumber()[0];
    }

    private int sumStrike(List<Frame> frameList, int index) {
        if(index + 1 == frameList.size() - 1){
            return frameList.get(index).sumPinNumber() + frameList.get(index + 1).getPinNumber()[0] + frameList.get(index + 1).getPinNumber()[1];
        }else {
            if(frameList.get(index + 1).getThrowNumber() == 1){
                if(index + 2 == frameList.size() - 1){
                    return frameList.get(index).sumPinNumber() + frameList.get(index + 1).sumPinNumber() + frameList.get(index + 2).getPinNumber()[0];
                }else {
                    return frameList.get(index).sumPinNumber() + frameList.get(index + 1).sumPinNumber() + frameList.get(index + 2).getPinNumber()[0];
                }
            }
            return frameList.get(index).sumPinNumber() + frameList.get(index + 1).getPinNumber()[0] + frameList.get(index + 1).getPinNumber()[1];
        }
    }
}
