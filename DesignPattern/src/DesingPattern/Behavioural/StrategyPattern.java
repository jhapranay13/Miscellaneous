package DesingPattern.Behavioural;

/**
 *
 * Change of Algorithm at run time. Works with the data being passed.
 *
 *
 */
interface ChessAlgo {
    int calculateNextStep();
}

class EasyAlgo implements ChessAlgo {

    @Override
    public int calculateNextStep() {
        return 1;
    }
}

class MediumAlgo implements ChessAlgo {

    @Override
    public int calculateNextStep() {
        return 2;
    }
}

class HardAlgo implements ChessAlgo {

    @Override
    public int calculateNextStep() {
        return 3;
    }
}

class ChessStrategy {
    ChessAlgo algo = new EasyAlgo();

    public int calculateNextStep() {
        return algo.calculateNextStep();
    }

    public void setAlgo(ChessAlgo algo) {
        this.algo = algo;
    }
}

public class StrategyPattern {

    public static void main(String args[]) {
        ChessStrategy strategy = new ChessStrategy();
        ChessAlgo mediumAlgo = new MediumAlgo();
        ChessAlgo hardAlgo = new HardAlgo();
        System.out.println(strategy.calculateNextStep());
        strategy.setAlgo(mediumAlgo);
        System.out.println(strategy.calculateNextStep());
        strategy.setAlgo(hardAlgo);
        System.out.println(strategy.calculateNextStep());

    }
}
