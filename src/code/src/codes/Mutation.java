package code.src.codes;

import java.util.ArrayList;
import java.util.List;

public class Mutation {

    public List<SolutionAndFitness> getMutation(List<SolutionAndFitness> oldPopulation,
                                                int numberOfMutation) {
        List<SolutionAndFitness> deepCopy = new ArrayList<>(oldPopulation);
        List<SolutionAndFitness> newPopulation = new ArrayList<>();
        for (int i = 0; i < numberOfMutation; i++) {
            int firstRandomNumberForOldPopulation = (int) Math.floor(Math.random() * ((deepCopy.size() - 1) - 0 + 1) + 0);
            SolutionAndFitness solutionList1 = deepCopy.get(firstRandomNumberForOldPopulation);

            List<Integer> solutionListOld = solutionList1.getSolution();
            List<Integer> solutionList = new ArrayList<>();
            for (Integer integer : solutionListOld)
                solutionList.add(integer);

            int firstRandomNumberSolutionList = (int) Math.floor(Math.random() * ((solutionList.size() - 1) - 0 + 1) + 0);
            int secondRandomNumberSolutionList = (int) Math.floor(Math.random() * ((solutionList.size() - 1) - 0 + 1) + 0);

            while (firstRandomNumberSolutionList == secondRandomNumberSolutionList) {
                firstRandomNumberSolutionList = (int) Math.floor(Math.random() * ((solutionList.size() - 1) - 0 + 1) + 0);
                secondRandomNumberSolutionList = (int) Math.floor(Math.random() * ((solutionList.size() - 1) - 0 + 1) + 0);
            }

            //swap two positions
            int tempValue = solutionList.get(firstRandomNumberSolutionList);
            solutionList.set(firstRandomNumberSolutionList, solutionList.get(secondRandomNumberSolutionList));
            solutionList.set(secondRandomNumberSolutionList, tempValue);
            SolutionAndFitness solutionAndFitnessNew = new SolutionAndFitness();

            solutionAndFitnessNew.setSolution(solutionList);
            int fitnessValue = solutionAndFitnessNew.calFitness(solutionList);
            solutionAndFitnessNew.setFitness(fitnessValue);

            newPopulation.add(solutionAndFitnessNew);

        }
        return newPopulation;
    }
}
