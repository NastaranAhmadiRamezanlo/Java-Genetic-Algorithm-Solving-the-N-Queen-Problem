package code.src.codes;

public class InitializeVariable {
    //parameters
    
    int numberOfSolution = 50;
    int numberOfQueen = 20;
    int mutationRate = 30;
    int maximumGeneration = 1000;
    int numberOfMutation = Math.round((mutationRate * numberOfSolution) / 100);
    int gridSizeValue = 790;

    public int getNumberOfSolution() {
        return numberOfSolution;
    }

    public void setNumberOfSolution(int numberOfSolution) {
        this.numberOfSolution = numberOfSolution;
    }

    public int getNumberOfQueen() {
        return numberOfQueen;
    }

    public void setNumberOfQueen(int numberOfQueen) {
        this.numberOfQueen = numberOfQueen;
    }

    public int getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(int mutationRate) {
        this.mutationRate = mutationRate;
    }

    public int getMaximumGeneration() {
        return maximumGeneration;
    }

    public void setMaximumGeneration(int maximumGeneration) {
        this.maximumGeneration = maximumGeneration;
    }

    public int getNumberOfMutation() {
        return numberOfMutation;
    }

    public void setNumberOfMutation(int numberOfMutation) {
        this.numberOfMutation = numberOfMutation;
    }

    public int getGridSizeValue() {
        return gridSizeValue;
    }

    public void setGridSizeValue(int gridSizeValue) {
        this.gridSizeValue = gridSizeValue;
    }
}
