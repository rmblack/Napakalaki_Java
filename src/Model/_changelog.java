//
/* CHANGELOG */
//

/* NOTA IMPORTANTE A LOS PROFESORES: 
 *
 * Éste archivo no forma parte del Proyecto, lo uso para anotar los
 * cambios realizados en la depuración y mantener notas como recordatorio
 * durante la realización de Napakalaki. Pueden ignorarlo ya que no afecta
 * al funcionamiento del programa.
 */

//
/* COMMENT SECTION */
//

/* Debug_i is added to a comment when it's made during a depuration session,
 * whoose number is i.
 * A brief explanation of changes is given.
 */

/* Class scheme and interaction scheme's names do not match sometimes.
 * If you encounter unrecognized functions check what name is being used
 */

/* WARNING: no behaviour is set in napakalaki if there's not enough
 * treasures. with actual game rules (last check 26/4/2015) it doesn't happen
 * but you may encounter it during debug sessions
 */

//
/* MODIFICATIONS SECTION */
//

/* Added Player.hasNecklace() as auxiliary method. You may change it
 * to detect any specific treasure given as arguement if needed later on
 */

/* Player.initTreasure() return value changed from boolean to void
 * I don't know why it has to be boolean, maybe they want it to return false
 * if an error ocured (maybe no avalible treasures?)
 */

//
/* DEBUG SECTION */
//

/*  DEBUG_1  
 *
 * -Code reordered.
 * -Eliminated all code related to Exmam 2.
 * -Addead Cheat Mode to class Dice, class Napakalaki:
 *    boolean CHEATMODE to activate, code added to functions that requiere
 *    modified behaviour (For debugging). Comment  with "//" on first release,
 *    leave in source code for future use.
 * -Classe code cleaned: (done/x)
 *    BadConsequence: Done
 *    CardDealer: Done
 *    CombatResult: Done
 *    Dice: Done
 *    Monster: Done
 *    Napakalaki: Done
 *    Player: Done 
 *    Prize: Done
 *    Treasure: Done
 *    TreasureKind: Done
 *
 * -Added Package test with command.java and gameTester.java:
 *    Theese work as a visual check to Napakalaki, to use them
 *    a name change was necessary
 * -Proyect name Changed from Napakalaki to Model
 * -Some function parameters have been renamed in class Player
 * -Fixes:
 *    BadConsequence.adjustToFitTreasureList rewritten
 *    Player.dead now initializes to true
 *    Player.discardHiddenTreasures discarding visible
 *    Player.canMakeTreasureVisible rewritten
 *    Player.buyLevels float to int conversion
 *    Player.getCombatLevel now correctly uses necklace
 */

//
/* PENDING TASKS SECTION */
//

/* -Test CardDealer unused & used usage
 * -Ruby translate once Debug_1 is complete
 */