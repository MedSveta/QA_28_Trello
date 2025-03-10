package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;
import static utils.RandomUtils.*;

public class DataProviderBoards {
    @DataProvider
    public Board[] newBoardDP(){
        Board board1 = Board.builder().boardTitle(generateString(6)).build();
        Board board2 = Board.builder().boardTitle(generateString(6)).build();
        Board board3 = Board.builder().boardTitle(generateString(6)).build();

        return new Board[]{board1,board2,board3};
    }
}
