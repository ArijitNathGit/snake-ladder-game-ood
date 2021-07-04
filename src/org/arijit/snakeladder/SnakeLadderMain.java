package org.arijit.snakeladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.arijit.snakeladder.model.Player;
import org.arijit.snakeladder.service.PlaySnakeLadder;

public class SnakeLadderMain {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Board Size : ");
		int boardSize = Integer.parseInt(br.readLine());
		
		System.out.println("Enter number of snakes : ");
		int numOfSnakes = Integer.parseInt(br.readLine());
		
		System.out.println("Enter number of ladders : ");
		int numOfLadders = Integer.parseInt(br.readLine());
		
		System.out.println("Enter number of players : ");
		int numOfPlayers = Integer.parseInt(br.readLine());
		
		PlaySnakeLadder game = new PlaySnakeLadder(boardSize, numOfSnakes, numOfLadders);
		
		for(int i = 0; i < numOfPlayers; i++) {
			System.out.println("Enter Player name : ");
			String playerName = br.readLine();
			Player player = new Player(playerName);
			game.addPlayer(player);
		}
		
		game.play();				
	}
}
