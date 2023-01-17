public class Game {
    private Room currentRoom;
    public Game(){
        public static void main(String[] args) {
            Game game = new Game;
            game.createRooms();
            game.play();
        }

        private void createRooms(){

            Room  Garden = new Room("You wake up in a lively green garden.");
            Room snailTunnels = new Room("You enter a dark tunnel coated with slime.....ew");
            Room  darkForest = new Room("You enter a spooky forest packed with dark oak trees.");
            Room goldenCastle = new Room("You walk up huge golden brick steps");
            Room Dungeon = new Room("short description goes here");

        }

        public void play() {
            printWelcome();


            boolean finished = false;
            while(!finished) {

            }
            System.out.println(("Thanks for playing"));
        }

        private void printWelcome() {
            System.out.println();
            System.out.println("Welcome to my text adventure game!"););
            System.out.println("You will find yourself in a garden maze, desperate to escape!");
            System.out.println("Type \\‘help\\\" if you need assistance");
            System.out.println();
            System.out.println("we will print a long room description here");
        }

    }
}
import java.util.HashMap;

