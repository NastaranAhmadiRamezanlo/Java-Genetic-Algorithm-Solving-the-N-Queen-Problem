package code.src.codes;

import java.util.ArrayList;
import java.util.List;

public class BestSolution {
    
    private Integer fitness;
    private List<Integer> bestSolution;


    public void showBestSolution(List<BestSolution> bestSolutionList) {
        if (bestSolutionList.size() > 0) {
            //print solutions and finish
            for (BestSolution bestSolution : bestSolutionList) {
                List<Integer> solutionList = bestSolution.getBestSolution();
                for (Integer solution : solutionList) {
                    System.out.print(" " + solution);
                }
                System.out.println("  Fitness " + bestSolution.getFitness());
            }
        }
    }

    public List<BestSolution> getBestSolution(List<SolutionAndFitness> solutionAndFitnessList)
    {

        List<BestSolution> bestSolutionList = new ArrayList<>();
        for (SolutionAndFitness solutionAndFitness : solutionAndFitnessList) {
            if (solutionAndFitness.getFitness() == 0) {
                BestSolution bestSolution = new BestSolution();
                bestSolution.setFitness(solutionAndFitness.getFitness());
                bestSolution.setBestSolution(solutionAndFitness.getSolution());
                bestSolutionList.add(bestSolution);
            }
        }

        return bestSolutionList;
    }

    public List<SolutionAndFitness> concatPopulationAndMiddleOneAndSort(List<SolutionAndFitness> solutionAndFitnessList,
                                                     List<SolutionAndFitness> listOfMutationSolutions,
                                                     int numberOfSolution){

        List<SolutionAndFitness> middlePopulationList = new ArrayList<>();
        for (SolutionAndFitness solutionAndFitness1 : solutionAndFitnessList)
            middlePopulationList.add(solutionAndFitness1);
        for (SolutionAndFitness solutionAndFitness2 : listOfMutationSolutions)
            middlePopulationList.add(solutionAndFitness2);

        SortedSolution sortedSolution = new SortedSolution();
        List<SolutionAndFitness> betterSolutionSortedList = sortedSolution.getSortedSolution(middlePopulationList);

        List<SolutionAndFitness> bestSolutionAndFitnessSorted = betterSolutionSortedList.subList(0,numberOfSolution);

        return bestSolutionAndFitnessSorted;
    }

    public Integer getFitness() {
        return fitness;
    }

    public void setFitness(Integer fitness) {
        this.fitness = fitness;
    }

    public List<Integer> getBestSolution() {
        return bestSolution;
    }

    public void setBestSolution(List<Integer> bestSolution) {
        this.bestSolution = bestSolution;
    }
}
