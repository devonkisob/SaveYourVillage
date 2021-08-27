import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    // Game variables
    String [] monsters = {"Fox", "Wolf", "Bear", "Dragon"};
    // Fox Stats
    int foxHealth = 150;
    int minFoxAttackDamage = 25;
    int maxFoxAttackDamage = 75;
    // Wolf Stats
    int wolfHealth = 200;
    int minWolfAttackDamage = 50;
    int maxWolfAttackDamage = 125;
    // Bear Stats
    int bearHealth = 300;
    int minBearAttackDamage = 75;
    int maxBearAttackDamage = 150;
    //Dragon Stats
    int dragonHealth = 500;
    int minDragonAttackDamage = 100;
    int maxDragonAttackDamage = 200;

    // Player stats
    int playerHealth = 500;
    // Fire Spell
    int minFireSpellDamage = 175;
    int maxFireSpellDamage = 225; 
    int fireSpellAmount = 2;
    // Earth Spell
    int minEarthSpellDamage = 125;
    int maxEarthSpellDamage = 175;
    int earthSpellAmount = 3;
    // Water Spell
    int minWaterSpellDamage = 75;
    int maxWaterSpellDamage = 125;
    int waterSpellAmount = 4; 
    // Air Spell
    int minAirSpellDamage = 25;
    int maxAirSpellDamage = 75; 
    int airSpellAmount = 6;

    boolean running = true;

    System.out.println("Welcome to the Forest! \nYou are a Wizard and your village is being terrorized by a Dragon. The Dragon and its fellow animal predators roam the forest and you're the only one that can stop them. Go protect your village!");

    GAME:
    while(running){

      // initializes general stats
      int enemyHealth = 0;
      int minEnemyAttackDamage = 0;
      int maxEnemyAttackDamage = 0;

      // for loop progressivley runs through each character
      for (int i = 0; i<monsters.length;i++){
        String threat = monsters[i];
        System.out.println("------------------------------------------------------");
        System.out.println("\t# A wild "+threat+" has appeared!\n");
        // resets player health after monster is defeated
        playerHealth = 500;
        // assigns health and attack values based on the monster you're fighting
        if(threat == "Fox"){
          enemyHealth = foxHealth;
          minEnemyAttackDamage = minFoxAttackDamage;
          maxEnemyAttackDamage = maxFoxAttackDamage;
        } else if (threat == "Wolf"){
          enemyHealth = wolfHealth; 
          minEnemyAttackDamage = minWolfAttackDamage;
          maxEnemyAttackDamage = maxWolfAttackDamage;
        } else if (threat == "Bear"){
          enemyHealth = bearHealth;
          minEnemyAttackDamage = minBearAttackDamage;
          maxEnemyAttackDamage = maxBearAttackDamage;
        } else if (threat == "Dragon"){
          enemyHealth = dragonHealth;
          minEnemyAttackDamage = minDragonAttackDamage;
          maxEnemyAttackDamage = maxDragonAttackDamage;
        }

        // while fighting enemy
        while(enemyHealth > 0){
          //displays current stats
          System.out.println("\tYour HP: "+ playerHealth);
          System.out.println("\t"+threat+ " HP:" +enemyHealth);
          System.out.println("\n\tHow would you like to attack?");
          System.out.println("\t1. Fire Spell ("+fireSpellAmount+"/2) *very high Damage*");
          System.out.println("\t2. Earth Spell ("+earthSpellAmount+"/3) *high Damage");
          System.out.println("\t3. Water Spell ("+waterSpellAmount+"/4) *low Damage*");
          System.out.println("\t4. Air Spell ("+airSpellAmount+"/6) *very low Damage*");

          // accepts users attack 
          String spell = input.nextLine();

          // if statements perform the spell based on chosen attack
          if(spell.equals("1")){
            // if no spells left
            if (fireSpellAmount == 0){
              System.out.println("You don't have any Fire Spells left ... Use a different spell!");
            } else{
              fireSpellAmount--;
              // randomizes value in between the monsters attack limitations
              int enemyAttack = (int)Math.floor(Math.random()*(maxEnemyAttackDamage-minEnemyAttackDamage+1)+minEnemyAttackDamage);

              int fireSpellDamage = (int)Math.floor(Math.random()*(maxFireSpellDamage-minFireSpellDamage+1)+minFireSpellDamage);

              // applies enemy damage 
              playerHealth -= enemyAttack;
              System.out.println("The "+threat+" did "+enemyAttack+ " Damage!");

              
              //if the monster kills you the game ends
              if(playerHealth<1){
                System.out.println("\t> The "+threat+" has killed you!");
                break GAME;
              }

              // applies player damage  
              enemyHealth -= fireSpellDamage;
              System.out.println("Your attack did "+fireSpellDamage+" Damage!");

              // if you defeat the monster the game goes on
              if (enemyHealth<1){
                System.out.println("\t# You have defeated the " +threat+"!");
              }
            }
          } else if (spell.equals("2")){
            if (earthSpellAmount == 0){
              System.out.println("You don't have any Earth Spells left ... Use a different spell!");
            } else{
              earthSpellAmount--;

              int enemyAttack = (int)Math.floor(Math.random()*(maxEnemyAttackDamage-minEnemyAttackDamage+1)+minEnemyAttackDamage);

              int earthSpellDamage = (int)Math.floor(Math.random()*(maxEarthSpellDamage-minEarthSpellDamage+1)+minEarthSpellDamage);

              // applies enemy damage 
              playerHealth -= enemyAttack;
              System.out.println("The "+threat+" did "+enemyAttack+ " Damage!");

              
              //if the monster kills you the game ends
              if(playerHealth<1){
                System.out.println("\t> The "+threat+" has killed you!");
                break GAME;
              }

              enemyHealth -= earthSpellDamage;
              System.out.println("Your attack did "+earthSpellDamage+" Damage!");

              if (enemyHealth<1){
                System.out.println("\t# You have defeated the " +threat+"!");
              }
            }
          } else if (spell.equals("3")){
            if (waterSpellAmount == 0){
              System.out.println("You don't have any Water Spells left ... Use a different spell!");
            } else{
              waterSpellAmount--;

              int enemyAttack = (int)Math.floor(Math.random()*(maxEnemyAttackDamage-minEnemyAttackDamage+1)+minEnemyAttackDamage);

              int waterSpellDamage = (int)Math.floor(Math.random()*(maxWaterSpellDamage-minWaterSpellDamage+1)+minWaterSpellDamage);

              playerHealth -= enemyAttack;
              System.out.println("The "+threat+" did "+enemyAttack+ " Damage!");

              if(playerHealth<1){
                System.out.println("\t> The "+threat+" has killed you!");
                break GAME;
              }

              enemyHealth -= waterSpellDamage;
              System.out.println("Your attack did "+waterSpellDamage+" Damage!");

              if (enemyHealth<1){
                System.out.println("\t# You have defeated the " +threat+"!");
              }
            }
          } else if (spell.equals("4")){
              if (airSpellAmount == 0){
                System.out.println("You don't have any Air Spells left ... Use a different spell!");
              } else{
                int enemyAttack = (int)Math.floor(Math.random()*(maxEnemyAttackDamage-minEnemyAttackDamage+1)+minEnemyAttackDamage);

                int airSpellDamage = (int)Math.floor(Math.random()*(maxAirSpellDamage-minAirSpellDamage+1)+minAirSpellDamage);

                enemyHealth -= airSpellDamage;
                System.out.println("Your attack did "+airSpellDamage+" Damage!");
                playerHealth -= enemyAttack;
                System.out.println("The "+threat+" did "+enemyAttack+ " Damage!");

                airSpellAmount--;

                if(playerHealth<1){
                  System.out.println("\t> The "+threat+" has killed you! \n Game Over!");
                  break GAME;
              } else if (enemyHealth<1){
                  System.out.println("\t# You have defeated the " +threat+"!");
              }
            }
          } else{
            System.out.println("Invalid Input!");
          }  
        } if (enemyHealth>0 && threat=="Dragon"){ // winning endgame message
          System.out.println("Congratulations! You saved your Village");
        }
      }
    }
  }
}