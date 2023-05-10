package converter;

import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;
    private NumberSystem numbers;
    private Converter converter;



    public UI() {
        this.scanner = new Scanner(System.in);
        this.numbers = new NumberSystem();
        this.converter = new Converter();
    }

    public void start() {
        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            String input = scanner.nextLine();

            if (input.equals("/exit")) {
                break;
            }

            String[] sourceTargetBase = input.split(" ");

            numbers.setSourceBase(Integer.parseInt(sourceTargetBase[0]));
            numbers.setTargetBase(Integer.parseInt(sourceTargetBase[1]));


            while (true) {
                System.out.println("Enter number in base " + sourceTargetBase[0] + " to convert to base " + sourceTargetBase[1] + " (To go back type /back)");
                String targetNumber = scanner.nextLine();

                if (targetNumber.equals("/back")) {
                    break;
                }

                numbers.setTargetNumber(targetNumber);
                System.out.println("Conversion result: " + converter.fromAnyBase(numbers.getSourceBase(), numbers.getTargetBase(), numbers.getTargetNumber()));
            }

        }
    }
}
