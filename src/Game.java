import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class Game {
    private Room currentRoom;
    private Parser parser;
    Player player;
    Item obj = new Item();
    Item obj2 = new Item();
    Item obj3 = new Item();
    public Game() {
        parser = new Parser();
        player = new Player();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.createRooms();
        game.play();
    }

    private void createRooms() {

        Room Garden = new Room("You enter a lively green garden filled with birds in need of a song.", "You take a glance around and find a lantern covered by leaves. There are many birds huddled around the statue of the greatest guitarist ever aka Dominic Marchiondo. You hear him call out to you and he says, Go young coder and find my guitar, but make sure you don't take and play the Guitar of Shadows.");
        Room snailTunnels = new Room("You enter a dark tunnel coated with slime.....ew", "You inspect the walls and notice there are giant snails everywhere! YUCK! You notice the bright light shining from the east......oooooo shiny");
        Room darkForest = new Room("You enter a spooky forest packed with dark oak trees.", "It is very dark, and in order to move further, your lantern definitely has to be turned on. You hear clanging metal from the east, but you also see a bright, shiny light from the south.");
        Room goldenCastle = new Room("You walk up huge golden brick steps", "You open these massive doors and notice everything inside looks enchanted. There are many rooms, but they are all locked. Sitting in the corner is a golden guitar with angelic voices coming off of the strings.");
        Room Dungeon = new Room("You see a big chained up house that looks very mysterious.", "You open a jail like door and notice skeletons and miscellaneous bones covering the floor. Under a pile of bones you see a dark guitar with shadow smoke pouring out of each string. It seems that the only way out is the way you came.");
        Garden.setExit("east", darkForest);
        Garden.setExit("south", snailTunnels);

        darkForest.setExit("east", Dungeon);
        darkForest.setExit("south", goldenCastle);
        darkForest.setExit("west", Garden);

        snailTunnels.setExit("north", Garden);
        snailTunnels.setExit("east", goldenCastle);

        goldenCastle.setExit("north", darkForest);
        goldenCastle.setExit("west", snailTunnels);

        Dungeon.setExit("west", darkForest);

        Item obj = new Item();
        Item obj2 = new Item();
        Item obj3 = new Item();
        Garden.setItem("lantern", obj);
        goldenCastle.setItem("guitar", obj2);
        Dungeon.setItem("shadowGuitar", obj3);
        currentRoom = Garden;
    }

    public void play() {
        printWelcome();


        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);

        }
        System.out.println(("Thanks for playing"));
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Whatchu mean bruh?");
                break;
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = true;
                break;
            case LOOK:
                look(command);
                break;
            case GRAB:
                grabItem(command);
                break;
            case DROP:
                dropItem(command);
                break;
            case WTF:
                System.out.println("You can't cuss here");
                System.out.println("It is family friendly");
                break;
            case PLAY:
                playItem(command);
                break;

        }
        return wantToQuit;
    }
    private void grab() {

    }
    private void drop(){

    }

    private void printHelp() {
        System.out.println("You are lost. You got no one.");
        System.out.println("You must play the tune where the flowers bloom");
        System.out.println("");
        System.out.println("Your command words are: go, look, quit, grab, amd drop");
    }

    private void look(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("You can't look at " + command.getSecondWord());
            return;
        }
        System.out.println(currentRoom.getLongDescription());
        System.out.println(player.getItemString());

    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go Where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());
        }
    }
    private void grabItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Whatchu tryna grab?");
            return;
        }
        String item = command.getSecondWord();
        Item itemGrabbed = currentRoom.getItem(item);

        if (itemGrabbed == null) {
            System.out.println("you can't grab  " + command.getSecondWord());
        }
        else {
            player.setItem(item, itemGrabbed);
        }
        System.out.println("You have grabbed da " + command.getSecondWord());
    }
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Whatchu tryna drop?");
            return;
        }
        String item = command.getSecondWord();
        Item itemDropped = player.getItem(item);
        if (itemDropped == null) {
            System.out.println("you can't drop " + command.getSecondWord());
        }
        else {
            currentRoom.setItem(item, itemDropped);
        }
        System.out.println("You have dropped da " + command.getSecondWord());
    }
    private void playItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Whatchu tryna play?");
            return;
        }
        String item = command.getSecondWord();
        Item itemPlayed = player.getItem(item);
        if(!itemPlayed.equals(obj2) ){
            System.out.println("You can't play " + command.getSecondWord());
        }
        else{
            System.out.println("urmom");

        }
    }
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("You cannot quit " + command.getSecondWord());
            return false;
        } else {
            return true;
        }
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to my text adventure game!");
        ;
        System.out.println("You are stuck in a mysterious maze, you must find the tunes to escape!");
        System.out.println("Type \"help\" if you need assistance");
        System.out.println();
        System.out.println("I suggest typing the command look in each room you go to.");
    }



}
