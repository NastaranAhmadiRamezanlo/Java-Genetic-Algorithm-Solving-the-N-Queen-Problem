package code.src.codes;

import java.util.ArrayList;
import java.util.List;

public class SolutionAndFitness  {
    private List<Integer> solution;
    private Integer fitness;

    public List<SolutionAndFitness> generateSolutionAndCalFitness(int numberOfSolution, int numberOfQueen) {
        List<SolutionAndFitness> solutionAndFitnessList = new ArrayList<>();
        Integer fitness;

        for (int i = 1; i <= numberOfSolution; i++) {
            List<Integer> solution = new ArrayList<>();
            for (int j = 1; j <= numberOfQueen; j++) {
                solution.add(j);
            }
            SolutionAndFitness solutionAndFitness = new SolutionAndFitness();
            java.util.Collections.shuffle(solution);
            solutionAndFitness.setSolution(solution);
            fitness = calFitness(solution);
            solutionAndFitness.setFitness(fitness);
            solutionAndFitnessList.add(solutionAndFitness);
        }
        return solutionAndFitnessList;
    }

    public static Integer calFitness(List<Integer> solution) {
        Integer fitness = 0;
        for (int i = 0; i < solution.size() - 1; i++) {
            for (int j = i + 1; j <= solution.size() - 1; j++) {
                int a = Math.abs(solution.get(i) - solution.get(j));
                int b = Math.abs(i - j);
                if (a == b)
                    fitness++;
            }
        }
        return fitness;
    }


    public List<Integer> getSolution() {
        return solution;
    }

    public void setSolution(List<Integer> solution) {
        this.solution = solution;
    }

    public Integer getFitness() {
        return fitness;
    }

    public void setFitness(Integer fitness) {
        this.fitness = fitness;
    }
}
