package jam.google.magicTrick;

import java.util.Arrays;

import jam.google.deployment.IProblemSolver;

public final class ProblemSolver implements IProblemSolver<TestCase> {
    
    @Override
    public String solve(TestCase instance) {
        Arrays.sort(instance.getFirstRow());
        Arrays.sort(instance.getSecondRow());
        int chosenCard = -1;

        for (int card1 : instance.getFirstRow()) {
            int position = Arrays.binarySearch(instance.getSecondRow(), card1);

            if (position >= 0) {
                if (chosenCard > -1) {
                    return "Bad magician!";
                }

                chosenCard = card1;
            }
        }

        if (chosenCard > -1) {
            return Integer.toString(chosenCard);
        }

        return "Volunteer cheated!";
    }
}
