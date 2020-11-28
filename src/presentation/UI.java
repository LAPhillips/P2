package presentation;

import java.util.Scanner;

import domain.Beings;
import domain.Controller;
import domain.Journey;

public class UI {
	private Controller control;
	private Scanner scan;

	public UI() {
		this.control = new Controller();
		this.scan = new Scanner(System.in);
	}

	public void setupGame() {
		Journey journey = control.getJourney();
		System.out.println("What is your name?");
		String name = scan.nextLine();
		System.out.println("Type first letter of the journey you would like to go on:");
		System.out.println("[C]edar Forest,  [M]ount Mashu,  [S]alted Sea");
		String response = scan.nextLine();
		journey.setupJourney(response, name);
		System.out.println("Great, you chose the " + journey.getJourneyType());
		fullJourney(journey);
	}
	
	//for testing
	public void setupGame(String response, String name) {
		Journey journey = control.getJourney();
		journey.setupJourney(response, name);
		System.out.println("Great, you chose the " + journey.getJourneyType());
		System.out.println();
		fullJourney(journey);
	}

	
	public void nextSteps(Journey journey) {    
		System.out.println("You can [T]ravel or see [M]enu for more options.");
		System.out.println("You have " + journey.getDistanceLeft() + " leagues left in your journey.");
		String response = scan.nextLine();
		if (response.equalsIgnoreCase("T") || response.equalsIgnoreCase("Travel")) {
			encounter(journey);
		}
		else if (response.equalsIgnoreCase("M") || response.equalsIgnoreCase("Menu")) {
			menu();
		}
		else if (response.equalsIgnoreCase("C") || response.equalsIgnoreCase("Check")) {
			checkHealth(journey);
		}
		else if (response.equalsIgnoreCase("L") || response.equalsIgnoreCase("Look")) {
			look(journey);
		}
	}
	
	private void look(Journey journey) {
		if (!journey.getAlreadyLooked()) {
			System.out.println(journey.manageLook());
		}
		else {
			System.out.println("You already explored this area. Consider moving on.");
		}
		
	}

	private void checkHealth(Journey journey) {
		System.out.println("YOUR STATS:");
		System.out.println("Hitpoints: " + journey.getPlayer().getHitpoints());
		System.out.println("Defense: " + (journey.getPlayer().getDefense()*-1));
//		System.out.println("Attack: " + journey.getPlayer().getAttackPoints());
	}

	private void menu() {
		System.out.println("MENU:");
		System.out.println("[T]ravel");
		System.out.println("[L]ook around");
		System.out.println("[C]heck your Stats");
		System.out.println("[E]nd game");
	}
	
	
	
	public void fullJourney(Journey journey) {
		while(journey.getPathTracker() < journey.getPath().length-1) {
			System.out.println();
			nextSteps(journey);
		}
		System.out.println("Congratulations, you made it to " + journey.getJourneyType());
	}

	public void encounter(Journey journey) {

		journey.newEncounter();
		System.out.println("You arrive at " + journey.encounterDescription());
		//do you get attacked?
		if (journey.isAttack()) {
			System.out.println("You get attacked by a " + journey.getCurrentCreature().getName()+ ".");
			//if yes, what attacks?
			fullBattle(journey.getCurrentCreature(), journey.getPlayer(), journey);
		}
		else {
			System.out.println("You enjoy your time here and relax.");
		}

	}
	
	public void battleAttack(Beings attacker, Beings attacked, Journey journey) {
		int attackRoll = attacker.seeIfAttack();
		if( attacked.getBaseAttack() + attacked.getDefense() >= attackRoll) { 	//does the player get hit?
			int hit = attacker.attack(); //if yes, the creature calculates how much they hit for
			attacked.damaged(hit); //player takes damage
			System.out.println(attacker.getName() + " attacks for " + attacker.getAttackPoints());
		}
		else {
			System.out.println(attacker.getName() + " missed " + attacked.getName());
		}
		journey.checkDeath(attacker, attacked);
	}
	
	public void fullBattle(Beings creature, Beings player, Journey journey) {
		while(creature.isAlive() && player.isAlive()) {
			battleAttack(creature, player, journey);
			if (!creature.isAlive()) {
				break;
			}
			System.out.println();
			System.out.println(player.getName() + ", it's your turn to attack.");
			System.out.println("[1] simple attack or [2] complex attack");
			String attackType = scan.nextLine();
			battleAttack(player, creature, journey);
		}
		whoIsAlive(creature, player);
		
	}
	
	public void whoIsAlive(Beings creature, Beings player) {
		if (!creature.isAlive()) {
			System.out.println(creature.getName() + " is slain.");
		}else {
			System.out.println("You were killed by a " + creature.getName());
		}
		
	}
	
	

	
	
}
