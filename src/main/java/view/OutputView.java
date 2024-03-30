package view;

import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import view.translator.ColumnSymbol;
import view.translator.PieceTranslator;

public class OutputView {

    public void printGameGuide() {
        System.out.print("""
                > 체스 게임을 시작합니다.
                > 게임 시작 : start
                > 게임 종료 : end
                > 게임 이동 : move source위치 target위치 - 예. move b2 b3
                > 게임 점수 : status
                """);
    }

    public void printBoard(Map<Coordinate, ChessPiece> board) {
        List<ChessPiece> boardValues = new ArrayList<>(board.values());
        int rowSize = ColumnSymbol.size();

        for (int row = 0; row < board.size(); row += rowSize) {
            List<ChessPiece> oneRowPieces = getOneRowPieces(boardValues, row, rowSize);

            for (ChessPiece piece : oneRowPieces) {
                System.out.print(PieceTranslator.getName(piece));
            }
            System.out.println();
        }
    }

    private List<ChessPiece> getOneRowPieces(List<ChessPiece> boardValues, int row, int rowSize) {
        return boardValues.subList(row, Math.min(row + rowSize, boardValues.size()));
    }

    public void printResult(Color color) {
        System.out.println(color + " 팀이 게임을 이겼습니다.");
    }

    public void printBlackStatus(double blackScore) {
        System.out.println(Color.BLACK + "의 점수는 " + blackScore + "입니다.");
    }

    public void printWhiteStatus(double whiteScore) {
        System.out.println(Color.WHITE + "의 점수는 " + whiteScore + "입니다.");
    }
}
