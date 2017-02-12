package guide.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import guide.commands.Command;
import guide.strategy.InputStrategy;

public class MerchantsGuide {
    List<Command> commands = new ArrayList<>();
    
    public void readInput(String input) {
        InputStrategy strategy = StrategyFactory.determineStrategy(input);
        Command c = CalcManager.getInstance().handle(strategy);
        commands.add(c);
        c.execute();
    }

    private void respond() {
    }

    public static void main(String[] args) {
        MerchantsGuide guide = new MerchantsGuide();
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()) {
            String input = in.nextLine();
            guide.readInput(input);
        }
        in.close();
        
        guide.respond();
    }
}
