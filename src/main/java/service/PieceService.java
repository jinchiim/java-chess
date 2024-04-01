package service;

import db.entity.Piece;
import domain.coordinate.Coordinate;
import domain.piece.base.ChessPiece;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import repository.ChessPieceRepository;
import view.translator.ColumnSymbol;
import view.translator.PieceTranslator;

public class PieceService {

    private final ChessPieceRepository chessPieceRepository;

    public PieceService() {
        this.chessPieceRepository = new ChessPieceRepository();
    }

    public void addPieces(Long gameId, Map<Coordinate, ChessPiece> board) throws SQLException {
        List<Piece> pieces = addInitPiece(board, gameId);
        chessPieceRepository.saveAll(gameId, pieces);
    }

    public void updatePiece(Long gameId, Coordinate start, Coordinate destination) throws SQLException {
        Long startPieceId = chessPieceRepository.findIdByRowAndColumnAndGameId(gameId, start.getRowPosition(),
                start.getColumnPosition());

        Long destinationPieceId = chessPieceRepository.findIdByRowAndColumnAndGameId(gameId,
                destination.getRowPosition(), destination.getColumnPosition());

        chessPieceRepository.updateRowAndColumn(startPieceId, destination.getRowPosition(),
                destination.getColumnPosition());
        chessPieceRepository.updateByRowAndColumnAndPieceType(destinationPieceId, start.getRowPosition(),
                start.getColumnPosition());
    }

    public void deletePieces(Long gameId) throws SQLException {
        chessPieceRepository.delete(gameId);
    }

    private List<Piece> addInitPiece(Map<Coordinate, ChessPiece> board, Long gameId) {

        int rowSize = ColumnSymbol.size();
        List<ChessPiece> boardValues = new ArrayList<>(board.values());
        List<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < board.size(); i += rowSize) {
            List<ChessPiece> oneRowPieces = getOneRowPieces(boardValues, i, rowSize);
            setSinglePieces(oneRowPieces, gameId, String.valueOf(8 - i / rowSize), pieces);
        }
        return pieces;
    }

    private void setSinglePieces(List<ChessPiece> oneRowPieces, Long gameId, String row, List<Piece> pieces) {
        for (int column = 0; column < ColumnSymbol.size(); column++) {
            PieceTranslator pieceType = PieceTranslator.from(oneRowPieces.get(column));
            ChessPiece singlePiece = oneRowPieces.get(column);

            pieces.add(Piece.createPiece(gameId, String.valueOf(pieceType), String.valueOf(singlePiece.getColor()),
                    row, String.valueOf(column + 1)));
        }
    }

    private List<ChessPiece> getOneRowPieces(List<ChessPiece> boardValues, int row, int rowSize) {
        return boardValues.subList(row, Math.min(row + rowSize, boardValues.size()));
    }
}
