public class NutriApp {
    private NutriAppUI ui = new NutriAppUI();

    public void run() {
        int choice = 0;
        while (choice != 5) {
            ui.displayMenu();
            choice = ui.getUserChoice();
            switch (choice) {
                case 1:
                    ui.displayUserForm();
                    break;
                case 2:
                    ui.displayMealForm();
                    break;
                case 3:
                    ui.displayWorkoutForm();
                    break;
                case 4:
                    ui.displayUserHistory();
                    break;
                case 5:
                    ui.displayExitMessage();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
