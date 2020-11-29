package presentation;

import java.util.Scanner;

import domain.Beings;
import domain.Controller;
import domain.EncounterType;
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
		else if (response.equalsIgnoreCase("E") || response.equalsIgnoreCase("End")) {
			journey.updateIsOver();

		}
	}
	
	public void look(Journey journey) {
		if (!journey.getAlreadyLooked()) {
			System.out.println(journey.getLook());
			//positive look
			if (journey.getLookType() == EncounterType.POSITIVE) {
				System.out.println("This is a boon for you. Your health has recovered some.");
				System.out.println("Hitpoints increased by " + journey.heal() + ".");
			}
			//neutral look
			else if(journey.getLookType() == EncounterType.NEUTRAL) {
				System.out.println("You don't see anything else of interest. Time to move on.");
			}
			//negative look
			else {
				Beings creature = journey.getNewCreature();
				fullBattle(creature, journey.getPlayer(), journey);
			}
		}
		else {
			System.out.println("You already looked around this area. Consider moving on.");
		}
		
	}

	public void checkHealth(Journey journey) {
		System.out.println("YOUR STATS:");
		System.out.println("Hitpoints: " + journey.getPlayer().getHitpoints());
		System.out.println("Defense: " + (journey.getPlayer().getDefense()*-1));
//		System.out.println("Attack: " + journey.getPlayer().getAttackPoints());
	}

	public void menu() {
		System.out.println("MENU:");
		System.out.println("[T]ravel");
		System.out.println("[L]ook around");
		System.out.println("[C]heck your Stats");
		System.out.println("[E]nd game");
	}
	
	
	
	public void fullJourney(Journey journey) {
		while(journey.getPathTracker() < journey.getPath().length-1 && !journey.getIsOver()) {
			System.out.println();
			nextSteps(journey);
		}
		endGame(journey.getPlayer(), journey);
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
		if( journey.isHit(attacker, attacked)) { 	//does the player get hit?
			journey.takesDamage(attacker, attacked); //if hit, they take damage
			System.out.println();
			System.out.println(attacker.getName() + " attacks for " + attacker.getAttackPoints() + " damage.");
			journey.checkDeath(attacker, attacked); //check to see if the participants are still alive
			if (attacked.isAlive()) {
				System.out.println(attacked.getName() + " has " + attacked.getHitpoints() + " hitpoints left.");
			}
		}
		else {
			System.out.println(attacker.getName() + " missed " + attacked.getName() + "."); //if they don't get hit nothing happens
		}
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
	
	public void endGame(Beings player, Journey journey) {
		if (journey.getIsOver()) {
			System.out.println("You have decided to end your journey and return back to your normal life.");
		}else {
			if (player.isAlive()) {
				System.out.println();
				System.out.println("Congratulations! After a long and arduous journey. You have finally made it to "  
						+ journey.getJourneyType() + ".");
				System.out.println("Your name will be etched on the tablets held in Ashurbanipal's library and your legacy will live on in story.");
			}
			else {
				System.out.println("You have died. Your journey will remain unfulfilled.");
			}
		}
	}
	
	
	

	
	
}
