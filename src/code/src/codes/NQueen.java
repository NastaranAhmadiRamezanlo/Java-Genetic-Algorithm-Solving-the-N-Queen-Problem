package code.src.codes;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String args[]) {

        //objects
        SolutionAndFitness solutionAndFitness = new SolutionAndFitness();
        BestSolution bestSolutionObj = new BestSolution();
        Mutation mutation = new Mutation();
        InitializeVariable initializeVariable = new InitializeVariable();

        int numberOfSolution = initializeVariable.getNumberOfSolution();
        int numberOfQueen = initializeVariable.getNumberOfQueen();

        //initial population
        List<SolutionAndFitness> solutionAndFitnessList = solutionAndFitness.generateSolutionAndCalFitness(numberOfSolution, numberOfQueen);
        List<Double> curveValues = new ArrayList<>();
        //Evolution solutions
        int generation = 1;
        int MaximumGeneration = initializeVariable.getMaximumGeneration();
        while (generation <= MaximumGeneration) {
            List<SolutionAndFitness> listOfMutationSolutions = mutation.getMutation(solutionAndFitnessList,
                    initializeVariable.getNumberOfMutation());

            solutionAndFitnessList = bestSolutionObj.concatPopulationAndMiddleOneAndSort(solutionAndFitnessList, listOfMutationSolutions, numberOfSolution);
            List<BestSolution> bestSolutionList = bestSolutionObj.getBestSolution(solutionAndFitnessList);
            bestSolutionObj.showBestSolution(bestSolutionList);
            System.out.println(" current generation is : " + generation + " and best solution fitness is : " + solutionAndFitnessList.get(0).getFitness());
            generation++;
            if (generation % 3 == 0)
                curveValues.add(solutionAndFitnessList.get(0).getFitness().doubleValue());

            if (bestSolutionList.size() > 0) {
                List<Integer> bestSolution = bestSolutionList.get(0).getBestSolution();
                for (int i = 0; i < bestSolution.size(); i++) {
                    int temp = (i) + numberOfQueen * (bestSolution.get(i) - 1);
                    bestSolution.set(i, temp);
                }
                NQueenGrid nQueenGrid = new NQueenGrid(bestSolution, numberOfQueen, initializeVariable.getGridSizeValue());
                //best solutions are found and finish.
                for (Integer integer : bestSolution) {
                    System.out.print(integer + "  ");
                }
                GraphPanel.curveValues = curveValues;
                GraphPanel.createAndShowGui();
                break;
            }
        }

    }
}