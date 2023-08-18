package code.src.codes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedSolution {
    public List<SolutionAndFitness> getSortedSolution(List<SolutionAndFitness> middlePopulationList) {

        Collections.sort(middlePopulationList, new Comparator<SolutionAndFitness>() {
            @Override
            public int compare(SolutionAndFitness a1, SolutionAndFitness a2) {
                return a1.getFitness() - a2.getFitness();
            }
        });
        return middlePopulationList;
    }
}
