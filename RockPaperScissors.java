
    import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your choice (rock, paper, or scissors): ");
        String userChoice = scanner.nextLine().toLowerCase();
        
        String[] choices = {"rock", "paper", "scissors"};
        int computerChoiceIndex = (int) (Math.random() * 3);
        String computerChoice = choices[computerChoiceIndex];
        
        System.out.println("Computer chooses: " + computerChoice);
        
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}

