package jam.google.deceitfulWar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {
    
    @Override
    public String solve(TestCase instance) {
        Arrays.sort(instance.getNaomi());
        Arrays.sort(instance.getKen());
        int deceitResult = this.solveDeceitfulWar(
                this.toList(instance.getNaomi()),
                this.toList(instance.getKen()));
        int warResult = this.solveWar(this.toList(instance.getNaomi()),
                this.toList(instance.getKen()));

        return String.format("%d %d", deceitResult, warResult);
    }

    private ArrayList<Double> toList(double[] array) {
        ArrayList<Double> list = new ArrayList<Double>();

        for (double d : array) {
            list.add(d);
        }

        return list;
    }

    private int solveWar(ArrayList<Double> naomi, ArrayList<Double> ken) {
        int naomiScore = 0;

        while (!naomi.isEmpty()) {
            double chosenNaomi = naomi.remove(0);
            int chosenKenIndex = this.performKenStrategy(ken, chosenNaomi);
            double chosenKen = ken.remove(chosenKenIndex);

            if (chosenNaomi > chosenKen)
                naomiScore++;
        }

        return naomiScore;
    }

    private int solveDeceitfulWar(ArrayList<Double> naomi, ArrayList<Double> ken) {
        int naomiScore = 0;

        while (!naomi.isEmpty()) {
            double chosenNaomi = naomi.remove(0);
            int chosenKenIndex;

            if (ken.size() == 1) {
                chosenKenIndex = 0;
            } else {
                double toldNaomi;
                double minKen = ken.get(0);
                double kenBase;

                if (chosenNaomi > minKen) {
                    kenBase = ken.get(ken.size() - 1);

                } else {
                    kenBase = ken.get(ken.size() - 2);
                }

                toldNaomi = kenBase + 0.0000001;
                chosenKenIndex = this.performKenStrategy(ken, toldNaomi);
            }

            double chosenKen = ken.remove(chosenKenIndex);

            if (chosenNaomi > chosenKen)
                naomiScore++;
        }

        return naomiScore;
    }

    private int performKenStrategy(ArrayList<Double> ken, double chosenNaomi) {
        int chosenKenIndex = -1 * Collections.binarySearch(ken, chosenNaomi)
                - 1;

        if (chosenKenIndex == ken.size())
            chosenKenIndex = 0;

        return chosenKenIndex;
    }
}
