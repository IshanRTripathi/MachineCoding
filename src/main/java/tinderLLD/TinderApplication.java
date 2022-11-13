package tinderLLD;

import java.util.Scanner;

import tinderLLD.controller.GlobalController;
import tinderLLD.entities.request.CreateUserRequest;

public class TinderApplication {
    static GlobalController controller;
    public static void main(String[] args) {
        controller = new GlobalController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input");

        while(true){
            String input = sc.nextLine();
            switch (input){
                case "1": //create_account
                    String userName = sc.nextLine();
                    int lat = Integer.parseInt(sc.nextLine());
                    int lon = Integer.parseInt(sc.nextLine());
                    int age = Integer.parseInt(sc.nextLine());
                    String gender = sc.nextLine();
                    controller.createUser(new CreateUserRequest(userName, lat, lon, age, gender));
                    break;
                case "2"://potential_match
                    String userName1 = sc.nextLine();
                    controller.getPotentialUsers(userName1);
                    break;
                case "3"://like
                    String u1 = sc.nextLine();
                    String u2 = sc.nextLine();
                    controller.performLikeOperation(u1, u2);
                    break;
                case "4"://show_matches
                    String userName2 = sc.nextLine();
                    controller.showAllMatchesByUser(userName2);
                    break;
                case "5"://show_all_matches
                    controller.showAllMatches();
                    break;
                case "6"://delete_account
                    String user = sc.nextLine();
                    controller.deleteAccount(user);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
