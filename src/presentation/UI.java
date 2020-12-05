package presentation;

import java.util.Scanner;

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
				System.out.println("Hitpoints increased by " + journey.heal() + ".");
			}
			//neutral look
			else if(journey.getLookType() == EncounterType.NEUTRAL) {
				System.out.println("You don't see anything of interest. Time to move on.");
			}
			//negative look
			else {
				Beings creature = journey.getNewCreature();
				fullBattle(creature, (Player) journey.getPlayer(), journey);
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
	

	public void fullJourney(Journey journey) {
		while(journey.getPathTracker() < journey.getPath().length-1 && !journey.getIsOver()) {
			System.out.println();
			nextSteps(journey);
			if (!journey.getPlayer().isAlive()) {
				break;
			}
		}
		endGame(journey.getPlayer(), journey);
	}

	public void encounter(Journey journey) {

		journey.newEncounter();
		System.out.println("You arrive at " + journey.encounterDescription());
		//do you get attacked?
		if (journey.isAttack()) {
			//if yes, what attacks?
			System.out.println("You get attacked by a " + journey.getCurrentCreature().getName() + " "
					+ journey.getCurrentCreature().getDifficulty() + ".");
			fullBattle(journey.getCurrentCreature(), (Player) journey.getPlayer(), journey);
		}
		else if(journey.isBoon()) {
			System.out.println(journey.getBoon());
			System.out.println(journey.implementBoon());
			journey.newBoon();
			
		}
		else {
			System.out.println("It is peaceful here. You enjoy your time here and relax.");
		}

	}
	
	public void creatureAttack(Beings attacker, Beings attacked, Journey journey) {
		if( journey.isHit(attacker, attacked)) { 	//does the player get hit?
			journey.takesDamage(attacker, attacked); //if hit, they take damage
			System.out.println();
			System.out.println(attacker.getName() + " attacks for " + attacker.getAttackPoints() + " damage.");
			journey.checkDeath(attacker, attacked); //check to see if the participants are still alive
			if (attacked.isAlive()) {
				System.out.println("You have " + attacked.getHitpoints() + " hitpoints left.");
			}
		}
		else {
			System.out.println(attacker.getName() + " missed " + attacked.getName() + "."); //if they don't get hit nothing happens
		}
	}
	
	public void playerAttack(Player attacker, Beings attacked, Journey journey, int attackType) {
		if( journey.isHit(attacker, attacked, attackType)) { 	//does the player get hit?
			journey.takesDamage(attacker, attacked, attackType); //if hit, they take damage
			System.out.println();
			System.out.println("You attack for " + attacker.getAttackPoints() + " damage.");
			journey.checkDeath(attacker, attacked); //check to see if the participants are still alive
			if (attacked.isAlive()) {
				System.out.println(attacked.getName() + " has " + attacked.getHitpoints() + " hitpoints left.");
			}
		}
		else {
			System.out.println("You missed " + attacked.getName() + "."); //if they don't get hit nothing happens
		}
	}


	public void fullBattle(Beings creature, Player player, Journey journey) {
		while(creature.isAlive() && player.isAlive()) {
			creatureAttack(creature, player, journey);
			if (!creature.isAlive()) {
				break;
			}
			System.out.println();
			System.out.println(player.getName() + ", it's your turn.");
			System.out.println("[1] basic attack, [2] complex attack, or [3] run away");
			String attackTypeEntered = scan.nextLine(); 
			int attackType = attackType(attackTypeEntered);
			playerAttack(player, creature, journey, attackType);	
		}
		whoIsAlive(creature, player, journey);
		
	}
	
	public int attackType(String attackTypeEntered) {
		int attackType = 0;;
		if (Character.isDigit(attackTypeEntered.charAt(0))) { //checking to see if it is a digit
			attackType = Integer.parseInt(attackTypeEntered); //turning it into int
			if (attackType < 0 && attackType > 4) { //making sure it is in the ui menu range
				attackType = 1; //if not, automatically set to default (1)
			}
		}
		else { //if it isn't a digit
			attackType = 1; //set it to default(1)
		}
		return attackType;
	}
	
	public void whoIsAlive(Beings creature, Beings player, Journey journey) {
		if (!creature.isAlive()) {
			System.out.println(creature.getName() + " is slain.");
		}else {
			System.out.println("You were killed by a " + creature.getName());
			player.checkDeath();
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
