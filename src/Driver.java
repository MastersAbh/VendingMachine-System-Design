import controller.MachineController;

import java.util.Objects;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        MachineController machineController = new MachineController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] commands = line.split(" ");

            switch (commands[0]) {
                case "create" :
                    machineController.createMachine(commands[1]);
                    break;
                case "slot" :
                    if (Objects.equals(commands[1], "add")) {
                        System.out.println(commands[2]);
                        machineController.addSlot(commands[2]);
                    } else if (Objects.equals(commands[1], "remove")) {
                        machineController.removeSlot(commands[2]);
                    }
                    break;
                case "get" :
                    machineController.getAllSlots();
                default:
                    break;
            }
        }
    }
}
