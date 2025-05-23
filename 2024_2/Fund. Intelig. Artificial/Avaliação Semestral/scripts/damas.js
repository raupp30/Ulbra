var red = 1;
var redKing = 1.1
var black = -1;
var blackKing = -1.1
var empty = 0;
var player = red;
var computer = black;
var currentBoard = {};
var INFINITY = 10000;
var NEG_INFINITY = -10000;
var cell_width = 0;
var board_origin = 0;

function initializeBoard() {
	var initialBoard = [[red, empty, red, empty, red, empty, red, empty],
						[empty, red, empty, red, empty, red, empty, red],
						[red, empty, red, empty, red, empty, red, empty],
						[empty, empty, empty, empty, empty, empty, empty, empty],
						[empty, empty, empty, empty, empty, empty, empty, empty],
						[empty, black, empty, black, empty, black, empty, black],
						[black, empty, black, empty, black, empty, black, empty],
						[empty, black, empty, black, empty, black, empty, black]
					   ];

	var cells = new Array();
	var pieces = new Array();
	for (var i=0;i<initialBoard.length;i++){
		var row = initialBoard[i];
		for (var j=0;j<row.length;j++) {
			var colValue=row[j];
			if (colValue != empty) {
				var piece = {row: i, col: j, state: colValue};
				pieces.push(piece);
			}
			var cell = {row: i, col: j, state: colValue};
			cells.push(cell);
		}
	}

	return {cells: cells, pieces: pieces, turn: red};
}

function mapCellToCoordinates(origin, width, cell) {
	var key = "" + cell.row + ":" + cell.col;
	if (!mapCellToCoordinates.answers) mapCellToCoordinates.answers = {};
	if (mapCellToCoordinates.answers[key] != null){
		return mapCellToCoordinates.answers[key];
	}
	var x = origin.x + (cell.col * width);
	var y = origin.y + (cell.row * width);
	return mapCellToCoordinates.answers[key] = {x: x , y: y};
}

function mapCoordinatesToCell(origin, width, cells, x, y){
	var numSquares = 8;
	var boardLength = numSquares * width;
	if (x > (origin.x + boardLength)) return null;
	if (y > (origin.y + boardLength)) return null;
	var col = Math.ceil((x - origin.x) / width) - 1;
	var row = Math.ceil((y - origin.y) / width) - 1;
	var index = ((row * numSquares) + col);
	var cell = cells[index];

	return cell;
}

function startGame(origin, cellWidth, boardCanvas) {
	movePiece.moves = [];
	cell_width = cellWidth;
	board_origin = origin;
	currentBoard = drawBoard(origin, cellWidth, boardCanvas);
	currentBoard.ui = true;
	showBoardState();
}

function undoMove(move, moveNum) {
	if (move.to.row > -1){
		var cellCoordinates = mapCellToCoordinates(board_origin, cell_width, move.from);
		d3.selectAll("circle").each(function(d,i) {
			if (d.col === move.to.col && d.row === move.to.row){
				d3.select(this)
				.transition()
				.delay(500 * moveNum)
				.attr("cx", d.x = cellCoordinates.x + cell_width/2)
				.attr("cy", d.y = cellCoordinates.y + cell_width/2);

				d.col = move.from.col;
				d.row = move.from.row;
			}
		});
		var toIndex = getCellIndex(move.to.row, move.to.col);
		var cell = currentBoard.cells[toIndex];
		cell.state = 0;
		var fromIndex = getCellIndex(move.from.row, move.from.col);
		cell = currentBoard.cells[fromIndex];
		cell.state = move.piece.state;
	}else {
		d3.selectAll("circle").each(function(d,i) {
			if (d.lastRow === move.from.row && d.lastCol === move.from.col){
				d3.select(this).transition().delay(500 * moveNum)
					.style("display", "block");
				d.col = move.from.col;
				d.row = move.from.row;

				var fromIndex = getCellIndex(move.from.row, move.from.col);
				var cell = currentBoard.cells[fromIndex];
				cell.state = move.piece.state;
				var pieceIndex = getPieceIndex(currentBoard.pieces, move.from.row, move.from.col);
				var piece = currentBoard.pieces[pieceIndex];
				piece.col = move.from.col;
				piece.row = move.from.row; 
				piece.state = move.piece.state;
			}
		});
	}

}

function undo(numBack) {
	var computerUndo = 0;
	var lastTurn = player;
	var moveNum = 0;
	while (true) {
		moveNum += 1;
		var lastMove = movePiece.moves.pop();
		if (lastMove == null) {
			break;
		}
		if (lastTurn === player && lastMove.piece.state === computer) {
			computerUndo += 1
			if (computerUndo > numBack) {
				break;
			}
		}
		if (lastMove.to.col > -1) {
			lastTurn = lastMove.piece.state;
		}
		undoMove(lastMove, moveNum);
		showBoardState();
	}
}

function movePiece(boardState, piece, fromCell, toCell, moveNum) {
	if (boardState.ui) {
		if (movePiece.moves == null) {
			movePiece.moves = [];
		}
		movePiece.moves.push({piece: { col: piece.col, row: piece.row, state: piece.state}, 
										from: {col: fromCell.col, row: fromCell.row}, 
										to: {col: toCell.col, row: toCell.row}});
	}

	var jumpedPiece = getJumpedPiece(boardState.cells, boardState.pieces, fromCell, toCell);

	var fromIndex = getCellIndex(fromCell.row, fromCell.col);
	var toIndex = getCellIndex(toCell.row, toCell.col);
	if ((toCell.row === 0 || toCell.row === 8) && Math.abs(piece.state) === 1) {
		boardState.cells[toIndex].state = piece.state * 1.1;
	}
	else {
		boardState.cells[toIndex].state = piece.state;
	}
	boardState.cells[fromIndex].state = empty;
	if ((toCell.row === 0 || toCell.row === 7) && Math.abs(piece.state) === 1) {
		piece.state = piece.state * 1.1
	}
	piece.col = toCell.col;
	piece.row = toCell.row;

	if (boardState.ui && (boardState.turn === computer || moveNum > 1)) {
		moveCircle(toCell, moveNum);
	}

	if (jumpedPiece != null) {
		var jumpedIndex = getPieceIndex(boardState.pieces, jumpedPiece.row, jumpedPiece.col);
		var originialJumpPieceState = jumpedPiece.state;
		jumpedPiece.state = 0;

		var cellIndex = getCellIndex(jumpedPiece.row, jumpedPiece.col);
		var jumpedCell = boardState.cells[cellIndex];
		jumpedCell.state = empty;
		boardState.pieces[jumpedIndex].lastCol = boardState.pieces[jumpedIndex].col;
		boardState.pieces[jumpedIndex].lastRow = boardState.pieces[jumpedIndex].row;
		boardState.pieces[jumpedIndex].col = -1;
		boardState.pieces[jumpedIndex].row = -1;
		if (boardState.ui) {
			hideCircle(jumpedCell, moveNum);
		}

		if (boardState.ui) {
			movePiece.moves.push({piece: { col: jumpedPiece.col, row: jumpedPiece.row, state: originialJumpPieceState}, 
											from: {col: jumpedCell.col, row: jumpedCell.row}, 
											to: {col: -1, row: -1}});
		}

		var more_moves = get_available_piece_moves(boardState, piece, boardState.turn);
		var another_move = null;
		for (var i=0; i<more_moves.length; i++) {
			more_move = more_moves[i];
			if (more_move.move_type === "jump") {
				another_move = more_move;
				break;
			}
		}
		if (another_move != null) {
			moveNum += 1;
			boardState = movePiece(boardState, piece, another_move.from, another_move.to, moveNum);
			if (boardState.ui && boardState.turn === player) {
				boardState.numPlayerMoves += moveNum;
			}
		}
	}


	return boardState;
}

function getCellIndex(row, col) {
	var numSquares = 8;
	var index = ((row * numSquares) + col);
	return index;
}

function getPieceIndex(pieces, row, col) {
	var index = -1;
	for (var i=0; i<pieces.length;i++){
		var piece = pieces[i];
		if (piece.row===row && piece.col===col){
			index = i;
			break;
		}
	}
	return index;
}

function getPieceCount(boardState) {
	var numRed = 0;
	var numBlack = 0;
	var pieces = boardState.pieces;
	for (var i=0;i<pieces.length;i++) {
		var piece = pieces[i];
		if (piece.col >=0 && piece.row >=0){
			if (piece.state === red || piece.state === redKing) {
				numRed += 1;
			}
			else if (piece.state === black || piece.state === blackKing) {
				numBlack += 1;
			}
		}
	}

	return {red: numRed, black: numBlack};
}

function getScore(boardState) {
	var pieceCount = getPieceCount(boardState);
	var score = pieceCount.red - pieceCount.black;
	return score;
}

function getWinner(boardState) {
	var pieceCount = getPieceCount(boardState);
	if (pieceCount.red > 0  && pieceCount.black === 0) {
		return red;
	}
	else if (pieceCount.black > 0 && pieceCount.red === 0) {
		return black;
	}
	else return 0;
}

function dragStarted(d) {
	d3.select(this).classed("dragging", true);
}

function dragged(d) {
	if (currentBoard.gameOver) return;
	if (currentBoard.turn != red && currentBoard.turn != redKing) return;
	if (currentBoard.turn != player) return;
	var c = d3.select(this);
	d3.select(this)
		.attr("cx", d.x = d3.event.x)
		.attr("cy", d.y = d3.event.y);
}

function moveCircle(cell, moveNum) {
	var cellCoordinates = mapCellToCoordinates(board_origin, cell_width, cell);
	currentBoard.delay = (moveNum * 500) + 500;
	d3.selectAll("circle").each(function(d,i) {
		if (d.col === cell.col && d.row === cell.row){
			d3.select(this)
			.transition()
			.delay(500 * moveNum)
			.attr("cx", d.x = cellCoordinates.x + cell_width/2)
			.attr("cy", d.y = cellCoordinates.y + cell_width/2);
		}
	});
}

function hideCircle(cell, moveNum) {
	currentBoard.delay = (moveNum * 600) + 500;
	d3.selectAll("circle").each(function(d,i) {
		if (d.state === 0 && d.lastRow === cell.row && d.lastCol === cell.col){
			console.log("Hide col=" + cell.col + ", row=" + cell.row);
			d3.select(this).transition().delay(600 * moveNum)
				.style("display", "none");
		}
	});
}

function dragEnded(origin, width, node, d) {
	if (currentBoard.turn != red && currentBoard.turn != redKing) return;
	if (currentBoard.turn != player) return;
	var cell = mapCoordinatesToCell(origin, width, currentBoard.cells, d.x, d.y);
	var from = d;
	var to = cell;
	var legal = isMoveLegal(currentBoard.cells, currentBoard.pieces, d, from, to);
	var index = getCellIndex(d.row, d.col);
	var originalCell = currentBoard.cells[index];
	if (!legal) {
		var cellCoordinates = mapCellToCoordinates(origin, width, originalCell);
		node
			.attr("cx", d.x = cellCoordinates.x + width/2)
			.attr("cy", d.y = cellCoordinates.y + width/2);
	}
	else {
		currentBoard = movePiece(currentBoard, d, originalCell, cell, 1);
		var cellCoordinates = mapCellToCoordinates(origin, width, cell);
		node
			.attr("cx", d.x = cellCoordinates.x + width/2)
			.attr("cy", d.y = cellCoordinates.y + width/2);

		var score = getScore(currentBoard);
		showBoardState();

		currentBoard.turn = computer;
		var delayCallback = function() {
			var winner = getWinner(currentBoard);
			if (winner != 0) {
				currentBoard.gameOver = true;
			}
			else {
				computerMove();
			}
			updateScoreboard();
	        return true;
		};

		var moveDelay = currentBoard.delay;
		setTimeout(delayCallback, moveDelay);		

	}
}

function getJumpedPiece(cells, pieces, from, to) {
    var distance = {x: to.col-from.col,y: to.row-from.row};
    if (abs(distance.x) == 2) {
		var jumpRow = from.row+sign(distance.y);
		var jumpCol = from.col+sign(distance.x);
		var index = getPieceIndex(pieces, jumpRow, jumpCol);
		var jumpedPiece = pieces[index];
		return jumpedPiece;
    }
    else return null;

}

function isMoveLegal(cells, pieces, piece, from, to) {
    if ((to.col < 0) || (to.row < 0) || (to.col > 7) || (to.row > 7)) {
        return false;
    }
    var distance = {x: to.col-from.col,y: to.row-from.row};
    if ((distance.x == 0) || (distance.y == 0)) {
        return false;
    }
    if (abs(distance.x) != abs(distance.y)) {
        return false;
    }
    if (abs(distance.x) > 2) {
        return false;
    }
    if (to.state != empty) {
        return false;
    }
    if (abs(distance.x) == 2) {
    	var jumpedPiece = getJumpedPiece(cells, pieces, from, to);
    	if (jumpedPiece == null) {
    		return false;
    	}
		var pieceState = integ(piece.state);
		var jumpedState = integ(jumpedPiece.state);
        if (pieceState != -jumpedState) {
        	return false;
    	}
    }
    if ((integ(piece.state) === piece.state) && (sign(piece.state) != sign(distance.y))) {
        return false;
    }

    return true;
}


function drawBoard(origin, cellWidth, boardCanvas) {
	var boardState = initializeBoard();
	var cells = boardState.cells;
	var pieces = boardState.pieces;

	boardCanvas.append("g")
				.selectAll("rect")
				.data(cells)
				.enter().append("rect")
				.attr("x", function(d) { return mapCellToCoordinates(origin, cellWidth, d).x})
				.attr("y", function(d) { return mapCellToCoordinates(origin, cellWidth, d).y})
				.attr("height", cellWidth)
				.attr("width", cellWidth)
				.style("fill", "white")
				.style("stroke", "black")
				.style("stroke-width", "1px");

	var dragEndedDimensions = function(d) {
		node = d3.select(this);
		dragEnded(origin, cellWidth, node, d);
	}

	var drag = d3.drag()
					.on("start", dragStarted)
					.on("drag", dragged)
					.on("end", dragEndedDimensions);

	boardCanvas.append("g")
				.selectAll("circle")
				.data(pieces)
				.enter().append("circle")
				.attr("r", cellWidth/2)
				.attr("cx", function(d) { var x = mapCellToCoordinates(origin, cellWidth, d).x; return x+cellWidth/2;})
				.attr("cy", function(d) { var y = mapCellToCoordinates(origin, cellWidth, d).y; return y+cellWidth/2;})
				.style("fill", function(d) { if (d.state == red) return "red"; else return "black";})
				.call(drag)
				;

	d3.select("#divScoreboard").remove();
	d3.select("body").append("div")
				.attr("id", "divScoreboard")
				.style("font-size", "36")
				.html("SCOREBOARD")

	d3.select("#divScoreboard")
		.append("div")
		.style("font-size", "24")
		.attr("id", "winner");

	d3.select("#divScoreboard")
				.append("div")
				.attr("id", "redScore")
				.style("font-size", "18")
				.html("Red: 12")

	d3.select("#divScoreboard")
				.append("div")
				.attr("id", "blackScore")
				.style("font-size", "18")
				.html("Black: 12")
				;

	return boardState;
}

function updateScoreboard() {
	var pieceCount = getPieceCount(currentBoard);
	var redLabel = "Red: " + pieceCount.red;
	var blackLabel = "Black: " + pieceCount.black;

	d3.select("#redScore")
		.html(redLabel);
	d3.select("#blackScore")
		.html(blackLabel);

	var winner = getWinner(currentBoard);
	var winnerLabel = "";
	if (winner === player) {
		winnerLabel = "Vermelho venceu!!";
	}
	else if (winner === computer) {
		winnerLabel = "Preto venceu!!";
	}

	d3.select("#winner")
		.html(winnerLabel);
}

function integ(num) {
    if (num != null)
        return Math.round(num);
    else
        return null;
}

function abs(num) {
    return Math.abs(num);
}

function sign(num) {
    if (num < 0) return -1;
    else return 1;
}

function drawText(data) {
	boardCanvas.append("g")
				.selectAll("text")
				.data(data)
				.enter().append("text")
				.attr("x", function(d) { var x = mapCellToCoordinates(board_origin, cell_width, d).x; return x+cell_width/2;})
				.attr("y", function(d) { var y = mapCellToCoordinates(board_origin, cell_width, d).y; return y+cell_width/2;})
				.style("fill", function(d) { if (d.state === red) return "black"; else return "white";})
				.text(function(d) { if (d.state === redKing || d.state === blackKing) return "K";
									else return "";})
				;
}

function showBoardState() {
	d3.selectAll("text").each(function(d,i) {
		d3.select(this)
			.style("display", "none");
	});

	var cells = currentBoard.cells;
	var pieces = currentBoard.pieces;
	drawText(pieces);
}

function copy_board(board) {
	var newBoard = {};
	newBoard.ui = false;
	var cells = new Array();
	var pieces = new Array();

	for (var i=0;i<board.cells.length;i++) {
		var cell = board.cells[i];
		var newCell = {row: cell.row, col: cell.col, state: cell.state};
		cells.push(newCell);
	}
	for (var i=0;i<board.pieces.length;i++){
		var piece = board.pieces[i];
		var newPiece = {row: piece.row, col: piece.col, state: piece.state};
		pieces.push(newPiece);
	}

	return {cells: cells, pieces: pieces, turn: board.turn};
}

function get_player_pieces(player, target_board) {
	player_pieces = new Array();
	for (var i=0;i<target_board.pieces.length;i++){
		var piece = target_board.pieces[i];
		if (piece.state === player || piece.state === (player+.1) || piece.state === (player-.1) ) {
			player_pieces.push(piece);
		}
	}
	return player_pieces;
}

function get_cell_index(target_board, col, row) {
	var index = -1;
	for (var i=0;i<target_board.cells.length;i++) {
		var cell = target_board.cells[i];
		if (cell.col === col && cell.row ===row) {
			index = i;
			break;
		}
	}
	return index;
}

function get_available_piece_moves(target_board, target_piece, player) {
    var moves = [];
    var from = target_piece;

	var x = [-1, 1];
	x.forEach(function(entry) {
		var cell_index = get_cell_index(target_board, from.col+entry, from.row+(player*1));
		if (cell_index >= 0){
	        var to = target_board.cells[cell_index];
	        if (isMoveLegal(target_board.cells, target_board.pieces, from, from, to)) {
	            move = {move_type: 'slide', piece: player, from: {col: from.col, row: from.row}, to: {col: to.col, row: to.row}};
	            moves[moves.length] = move;
	        }
		}
	});

	x = [-2, 2];
	x.forEach(function(entry) {
		var cell_index = get_cell_index(target_board, from.col+entry, from.row+(player*2));
		if (cell_index >= 0) {
	        var to = target_board.cells[cell_index];
	        if (isMoveLegal(target_board.cells, target_board.pieces, from, from, to)) {
	            move = {move_type: 'jump', piece: player, from: {col: from.col, row: from.row}, to: {col: to.col, row: to.row}};
	            moves[moves.length] = move;
	        }
		}
	});

	if (Math.abs(from.state) === 1.1) {
	    var x = [-1, 1];
	    var y = [-1, 1];
	    x.forEach(function(xmove) {
	        y.forEach(function(ymove){
	        	var cell_index = get_cell_index(target_board, from.col+xmove, from.row+ymove);
	        	if (cell_index >= 0){
		            var to = target_board.cells[cell_index];
		            if (isMoveLegal(target_board.cells, target_board.pieces, from, from, to)) {
		                move = {move_type: 'slide', piece: player, from: {col: from.col, row: from.row}, to: {col: to.col, row: to.row}};
		                moves[moves.length] = move;
		            }
	        	}
	        });
	    });

	    x = [-2, 2];
	    y = [-2, 2];
	    x.forEach(function(xmove) {
	        y.forEach(function(ymove){
	        	var cell_index = get_cell_index(target_board, from.col+xmove, from.row+ymove);
	        	if (cell_index >= 0){
		            var to = target_board.cells[cell_index];
		            if (isMoveLegal(target_board.cells, target_board.pieces, from, from, to)) {
		                move = {move_type: 'jump', piece: player, from: {col: from.col, row: from.row}, to: {col: to.col, row: to.row}};
		                moves[moves.length] = move;
		            }
	        	}
	        });
	    });
	}

	return moves;
}

function get_available_moves(player, target_board) {

    var moves = [];
    var move = null;
    var player_pieces = get_player_pieces(player, target_board);

    for (var i=0;i<player_pieces.length;i++) {
    	var from = player_pieces[i];
    	var piece_moves = get_available_piece_moves(target_board, from, player);
    	moves.push.apply(moves, piece_moves);
    }

    var jump_moves = [];
    for (var i=0; i<moves.length;i++) {
        var move = moves[i];
        if (move.move_type == "jump") {
            jump_moves.push(move);
        }
    }
    if (jump_moves.length > 0){
        moves = jump_moves;
    }

    return moves;
}

function select_random_move(moves){
    var index = Math.floor(Math.random() * (moves.length - 1));
    var selected_move = moves[index];

    return selected_move;
}

function alpha_beta_search(calc_board, limit) {
    var alpha = NEG_INFINITY;
    var beta = INFINITY;
    var available_moves = get_available_moves(computer, calc_board);
    var max = max_value(calc_board,available_moves,limit,alpha,beta);
    var best_moves = [];
    var max_move = null;
    for(var i=0;i<available_moves.length;i++){
        var next_move = available_moves[i];
        if (next_move.score == max){
            max_move = next_move;
            best_moves.push(next_move);
        }
    }

    if (best_moves.length > 1){
        max_move = select_random_move(best_moves);
    }

    return max_move;
}

function computerMove() {
    var simulated_board = copy_board(currentBoard);
    var selected_move = alpha_beta_search(simulated_board, 8);
    console.log("best move: " + selected_move.from.col + ":" + selected_move.from.row + " to " + selected_move.to.col + ":" + selected_move.to.row);
	var pieceIndex = getPieceIndex(currentBoard.pieces, selected_move.from.row, selected_move.from.col);
	var piece = currentBoard.pieces[pieceIndex];
	currentBoard = movePiece(currentBoard, piece, selected_move.from, selected_move.to, 1);
	moveCircle(selected_move.to, 1);
	showBoardState();

	var winner = getWinner(currentBoard);
	if (winner != 0) {
		currentBoard.gameOver = true;
	}
	else {
		currentBoard.turn = player;
		currentBoard.delay = 0;
	}
}

function jump_available(available_moves) {
    var jump = false;
    for (var i=0;i<available_moves.length;i++){
        var move = available_moves[i];
        if (move.move_type == "jump") {
            jump = true;
            break;
        }
    }

    return jump;
}

function min_value(calc_board, human_moves, limit, alpha, beta) {
    if (limit <=0 && !jump_available(human_moves)) {
        return utility(calc_board);
    }
    var min = INFINITY;
    if (human_moves.length > 0){
        for (var i=0;i<human_moves.length;i++){
            simulated_board = copy_board(calc_board);
            var human_move = human_moves[i];
			var pieceIndex = getPieceIndex(simulated_board.pieces, human_move.from.row, human_move.from.col);
			var piece = simulated_board.pieces[pieceIndex];
            simulated_board = movePiece(simulated_board, piece, human_move.from, human_move.to);
            var computer_moves = get_available_moves(computer, simulated_board);
            var max_score = max_value(simulated_board, computer_moves, limit-1, alpha, beta);

            if (max_score < min) {
                min = max_score;
            }
            human_moves[i].score = min;
            if (min <= alpha) {
                break;
            }
            if (min < beta) {
                beta = min;
            }
        }
    }
    return min;
}

function max_value(calc_board, computer_moves, limit, alpha, beta) {
    if (limit <= 0 && !jump_available(computer_moves)) {
        return utility(calc_board);
    }
    var max = NEG_INFINITY;
    if (computer_moves.length > 0){
        for (var i=0;i<computer_moves.length;i++){
            simulated_board = copy_board(calc_board);
            var computer_move = computer_moves[i];
			var pieceIndex = getPieceIndex(simulated_board.pieces, computer_move.from.row, computer_move.from.col);
			var piece = simulated_board.pieces[pieceIndex];
            simulated_board = movePiece(simulated_board, piece, computer_move.from, computer_move.to);
            var human_moves = get_available_moves(player, simulated_board);
            var min_score = min_value(simulated_board, human_moves, limit-1, alpha, beta);
            computer_moves[i].score = min_score;

            if (min_score > max) {
                max = min_score;
            }
            if (max >= beta) {
                break;
            }
            if (max > alpha) {
                alpha = max;
            }
        }
    }

    return max;

}

function evaluate_position(x , y) {
    if (x == 0 || x == 7 || y == 0 || y == 7){
        return 5;
    }
    else {
        return 3;
    }
}

function utility(target_board) {
    var sum = 0;
    var computer_pieces = 0;
    var computer_kings = 0;
    var human_pieces = 0;
    var human_kings = 0;
    var computer_pos_sum = 0;
    var human_pos_sum = 0;

    for (var i=0; i<target_board.pieces.length; i++) {
    	var piece = target_board.pieces[i];
    	if (piece.row > -1) {
	    	if (piece.state > 0) {
	            human_pieces += 1;
	            if (piece.state === 1.1){
	                human_kings += 1;
	            }
	            var human_pos = evaluate_position(piece.col, piece.row);
	            human_pos_sum += human_pos;
	    	}
	        else {
	            computer_pieces += 1;
	            if (piece.state === -1.1){
	                computer_kings += 1;
	            }
	            var computer_pos = evaluate_position(piece.col, piece.row);
	            computer_pos_sum += computer_pos;
	        }
    	}
    }

    var piece_difference = computer_pieces - human_pieces;
    var king_difference = computer_kings - human_kings;
    if (human_pieces === 0){
        human_pieces = 0.00001;
    }
    var avg_human_pos = human_pos_sum / human_pieces;
    if (computer_pieces === 0) {
        computer_pieces = 0.00001;
    }
    var avg_computer_pos = computer_pos_sum / computer_pieces;
    var avg_pos_diff = avg_computer_pos - avg_human_pos;

    var features = [piece_difference, king_difference, avg_pos_diff];
    var weights = [100, 10, 1];

    var board_utility = 0;

    for (var f=0; f<features.length; f++){
        var fw = features[f] * weights[f];
        board_utility += fw;
    }
    return board_utility;
}