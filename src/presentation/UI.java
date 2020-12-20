package presentation;

import java.util.Scanner;

import domain.BattleStates;
import domain.Beings;
import domain.Controller;
import domain.EncounterType;
import domain.Journey;
import domain.Player;

public class UI {
	private Controller control;
	private Scanner scan;

	public UI() {
		this.control = new Controller();
		this.scan = new Scanner(System.in);
	}

	public void setupGame() {
		Journey journey = control.getJourney();
		System.out.println();
		System.out.println(">>>----- TALE OF NAMMU -----<<< ");
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println();
		
		System.out.println("What is your name?");
		String name = scan.nextLine();
		System.out.println("As you were sleeping, Nammu came to you in a dream and urged you to explore beyond your home village.");
		System.out.println("Upon awaking, you know your destiny. Where will you go?");
		System.out.println();
		System.out.println("Type first letter of the journey you would like to go on:");
		System.out.println("[C]edar Forest,  [M]ount Mashu,  [S]alted Sea");
		String response = scan.nextLine();
		journey.setupJourney(response, name);
		System.out.println("Great, you chose the " + journey.getJourneyType());
		fullJourney();
	}
	
	//for testing
	public void setupGame(String response, String name) {
		Journey journey = control.getJourney();
		journey.setupJourney(response, name);
		System.out.println("Great, you chose the " + journey.getJourneyType());
		System.out.println();
		fullJourney();
	}

	public void nextSteps(Journey journey) {    
		System.out.println("You can [T]ravel or see [M]enu for more options.");
		System.out.println("You have " + journey.getDistanceLeft() + " leagues left in your journey.");
		String response = scan.nextLine();
		if (response.equalsIgnoreCase("T") || response.equalsIgnoreCase("Travel")) {
			encounter();
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
		else {
			System.out.println("Wrong input. Please pick an action from the menu.");
			menu();
		}
	}
	
	public void look(Journey journey) {
		if (!journey.getAlreadyLooked()) {
			System.out.println(journey.getLook());
			//positive look
			if (journey.getLookType() == EncounterType.POSITIVE) {
				System.out.println("This is a boon for you. Your health has recovered some.");
				System.out.println("Hitpoints increased by " + journey.implementHeal() + ".");
			}
			//neutral look
			else if(journey.getLookType() == EncounterType.NEUTRAL) {
				System.out.println("You don't see anything of interest. Time to move on.");
			}
			//negative look
			else {
				Beings creature = journey.getNewCreature();
				fullBattle(creature);
			}
		}
		//already looked around
		else {
			System.out.println("You already looked around this area. Consider moving on.");
		}
	}

	public void checkHealth(Journey journey) {
		System.out.println("YOUR STATS:");
		System.out.println("Hitpoints: " + journey.getPlayer().getHitpoints());
		System.out.println("Defense: " + (journey.getPlayer().getDefense()*-1));
		System.out.println("Attack Bonus: " + journey.getPlayer().getAttackBonus());
	}

	public void menu() {
		System.out.println("MENU:");
		System.out.println("[T]ravel");
		System.out.println("[L]ook around");
		System.out.println("[C]heck your Stats");
		System.out.println("[E]nd game");
	}

	public void fullJourney() {
		Journey journey = control.getJourney();
		while(journey.getPathTracker() < journey.getPath().length-1 && !journey.getIsOver()) {
			System.out.println();
			nextSteps(journey);
			if (!journey.getPlayer().isAlive()) {
				break;
			}
		}
		endGame(journey.getPlayer(), journey);
	}

	public void encounter() {
		EncounterType eState = control.implementEncounter();
		System.out.print("You arrive at " + control.getJourney());
		System.out.println();
		if(eState == EncounterType.POSITIVE) {
			System.out.println(control.getBoon());
		}
		else if (eState == EncounterType.NEGATIVE) {
			System.out.println("You get attacked by a " + control.getCreature() + " "
					+ control.getCreature().getDifficulty()+ ".");
			fullBattle(control.getCreature());
		}
		else {
			System.out.println("It is peaceful here. You enjoy your time here and relax.");
		}
	}
	
	public void creatureAttack(Journey journey, Beings creature) {
		BattleStates bState = control.creatureBattleStates(creature);
		System.out.println();
		if (bState == BattleStates.MISS) {
			System.out.println(control.getCreature() + " missed you."); //if they don't get hit nothing happens
		}
		else if (bState == BattleStates.DAMAGE) {
			System.out.println(control.getCreature() + " attacks for " + control.getHit() + " damage.");
			if (control.getPlayer().isAlive()) {
				System.out.println("You have " + control.getPlayer().getHitpoints() + " hitpoints left.");
			}
		}
	}
	
	public void playerAttack(Journey journey, int attackType) {
		BattleStates bState = control.playerBattleStates(attackType);
		if (bState == BattleStates.MISS) { //if hit is for 0
			System.out.println("You missed " + control.getCreature() + "."); //if they don't get hit nothing happens
		}
		else if (bState == BattleStates.DAMAGE) {
			System.out.println("You attack for " + control.getHit() + " damage.");
			if (control.getCreature().isAlive()) {
				System.out.println(control.getCreature() + "has " + control.getCreature().getHitpoints() + " hitpoints left.");
			}
		}
	}

	public void fullBattle(Beings creature) {
		Journey journey = control.getJourney();
		journey.setNewCreature(creature);
		while(journey.areAlive()) {
			creatureAttack(journey, creature);
			if (!journey.areAlive()) {
				break;
			}
			int attackType = whichAttack(control.getPlayer());
			playerAttack(journey, attackType);	
		}
		whoIsAlive(journey);
	}
	
	public int whichAttack(Player player) {
		System.out.println();
		System.out.println(player + ", it's your turn.");
		System.out.println("[1] basic attack or [2] complex attack");
		String attackTypeEntered = scan.nextLine(); 
		return control.attackType(attackTypeEntered);  //changes to int and makes sure no other options cause errors
	}
	
	public void whoIsAlive(Journey journey) {
		if (!journey.getCurrentCreature().isAlive()) {
			System.out.println(journey.getCurrentCreature() + " is slain.");
		}
		if (!journey.getPlayer().isAlive()) {
			System.out.println("You were killed by a " + journey.getCurrentCreature());
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
