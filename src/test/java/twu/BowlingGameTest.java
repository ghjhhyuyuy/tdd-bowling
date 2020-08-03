package twu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {
    private List<Frame> strikeInLastFrameList = new ArrayList<>();
    private List<Frame> spareInLastFrameList = new ArrayList<>();
    private List<Frame> notSpareAndStrikeInLastFrameList = new ArrayList<>();
    @BeforeEach
    private void creatFrameList() {
        Frame strikeFrame = new Frame(1, new int[]{10});
        Frame spareFrame = new Frame(2, new int[]{5, 5});
        Frame notSpareAndStrikeFrame = new Frame(2, new int[]{5, 3});
        Frame strikeInLastFrame = new Frame(3, new int[]{10, 5, 7});
        Frame spareInLastFrame = new Frame(3, new int[]{5, 5, 7});
        int strikeTime = 3;
        int spareTime = 3;
        int notSpareAndStrikeTime = 3;
        for (int i = 0; i < strikeTime; i++) {
            spareInLastFrameList.add(strikeFrame);
        }
        for (int i = 0; i < spareTime; i++) {
            spareInLastFrameList.add(spareFrame);
        }
        for (int i = 0; i < notSpareAndStrikeTime; i++) {
            spareInLastFrameList.add(notSpareAndStrikeFrame);
        }
        strikeInLastFrameList.addAll(spareInLastFrameList);
        notSpareAndStrikeInLastFrameList.addAll(spareInLastFrameList);
        strikeInLastFrameList.add(strikeInLastFrame);
        spareInLastFrameList.add(spareInLastFrame);
        notSpareAndStrikeInLastFrameList.add(notSpareAndStrikeFrame);
    }
    @Test
    void should_return_right_score_when_last_frame_strike() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        int strikeInLastFrameScore = 166;
        assertEquals(strikeInLastFrameScore,bowlingGame.score(strikeInLastFrameList));
    }
    @Test
    void should_return_right_score_when_last_frame_spare() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        int spareInLastFrameScore = 161;
        assertEquals(spareInLastFrameScore,bowlingGame.score(spareInLastFrameList));
    }
    @Test
    void should_return_right_score_when_last_frame_not_strike_or_spare() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        int notSpareAndStrikeInLastFrameScore = 152;
        assertEquals(notSpareAndStrikeInLastFrameScore,bowlingGame.score(notSpareAndStrikeInLastFrameList));
    }
    @Test
    void should_throw_exception_when_frameList_null_or_empty(){
        BowlingGame bowlingGame = new BowlingGame();
        Throwable exceptionInputEmpty = assertThrows(Exception.class, () -> bowlingGame.score(new ArrayList<>()));
        Throwable exceptionInputNull = assertThrows(Exception.class, () -> bowlingGame.score(null));
        assertEquals("input is wrong", exceptionInputEmpty.getMessage());
        assertEquals("input is wrong", exceptionInputNull.getMessage());
    }
}
