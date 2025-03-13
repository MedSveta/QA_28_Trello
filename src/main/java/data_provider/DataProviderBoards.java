package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.RandomUtils.*;

public class DataProviderBoards {
    @DataProvider
    public Board[] newBoardDP(){
        Board board1 = Board.builder().boardTitle(generateString(6)).build();
        Board board2 = Board.builder().boardTitle(generateString(6)).build();
        Board board3 = Board.builder().boardTitle(generateString(6)).build();

        return new Board[]{board1,board2,board3};
    }

    @DataProvider
    public Iterator<Board> newBoardDPFile(){
        List<Board>  boardList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/Boardtitle.csv"));
            String line = bufferedReader.readLine();
            while (line!= null){
                boardList.add(Board.builder().boardTitle(line).build());
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return boardList.listIterator();
    }
}
