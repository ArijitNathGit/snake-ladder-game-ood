package org.arijit.snakeladder.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

import org.arijit.snakeladder.model.Board;
import org.arijit.snakeladder.model.Dice;
import org.arijit.snakeladder.model.Ladder;
import org.arijit.snakeladder.model.Player;
import org.arijit.snakeladder.model.Snake;

public class PlaySnakeLadder {
	
	private int numOfSnake;
	private int numOfLadder;
	
	private Queue<Player> players;
	private Set<Snake> snakes;
	private Set<Ladder> ladders;
	
	private Board board;
	private  Dice dice;
	
	public PlaySnakeLadder(int boardSize, int numOfSnakes, int numOfLadders) {
		this.numOfLadder = numOfLadders;
		this.numOfSnake = numOfSnakes;
		snakes = new HashSet<>(numOfSnake);
		ladders = new HashSet<>(numOfLadder);
		
		players = new ArrayDeque<>();
		
		board = new Board(boardSize);
		dice = new Dice(1, 6);
		
		initBoard();
	}

	private void initBoard() {
		Set<String> slSet = new HashSet<>();
		
		IntStream.range(0, numOfSnake)
			.forEach(i -> {
				while(true) {
					int snakeStart = this.getRandomNumber(board.getStart(), board.getEnd() - 1);
					int snakeEnd = this.getRandomNumber(board.getStart(), board.getEnd() - 1);
					
					if( snakeStart >= snakeEnd ) continue;
					
					String startEndPair = snakeStart + "," + snakeEnd;
					if( !slSet.contains(startEndPair) ) {
						Snake snake = new Snake(snakeStart, snakeEnd);
						snakes.add(snake);
						slSet.add(startEndPair);
						break;
					}
				}
			});
		
		IntStream.range(0, numOfLadder)
		.forEach(i -> {
			while(true) {
				int ladderStart = this.getRandomNumber(board.getStart(), board.getEnd() - 1);
				int ladderEnd = this.getRandomNumber(board.getStart(), board.getEnd() - 1);
				
				if( ladderStart >= ladderEnd ) continue;
				
				String startEndPair = ladderStart + "," + ladderEnd;
				if( !slSet.contains(startEndPair) ) {
					Ladder ladder = new Ladder(ladderStart, ladderEnd);
					ladders.add(ladder);
					slSet.add(startEndPair);
					break;
				}
			}
		});	
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void play() {
		while(true) {
			Player currentPlayer = players.poll();
			int val = dice.roll();
			
			int newPosition= currentPlayer.getPosition() + val;
			
			if( newPosition > board.getEnd() ) {
				players.offer(currentPlayer);
			}
			else {
				currentPlayer.setPosition(this.getNewPosition(newPosition));
				
				if( currentPlayer.getPosition() == board.getEnd() ) {
					currentPlayer.setHaveWon(Boolean.TRUE);
					
					System.out.println("Player: " + currentPlayer.getName() + " Has Completed the Board.");
				}
				else {
					System.out.println("Player: " + currentPlayer.getName() + " Moves to position " + newPosition);
					players.offer(currentPlayer);
				}
			}
			
			if( players.size() < 2 ) break;
		}
		
		System.out.println(players.poll().getName() + " Loses the game !");
	}
	
	private int getNewPosition(int newPosition) {
		Optional<Snake> degradedPositionBySnake = snakes.stream()
											.filter(snake -> snake.getHead() == newPosition)
											.findFirst();
		if( degradedPositionBySnake.isPresent() ) {
			System.out.println("Snake Bit!");
			return degradedPositionBySnake.get().getTail();
		}
		
		Optional<Ladder> upgradedPositionByLadder = ladders.stream()
													.filter(ladder -> ladder.getStart() == newPosition)
													.findFirst();
		
		if( upgradedPositionByLadder.isPresent() ) {
			System.out.println("Climb Ladder!");
			return upgradedPositionByLadder.get().getEnd();
		}
		
		return newPosition;
	}

	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
}
