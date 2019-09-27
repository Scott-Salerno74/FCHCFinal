public class FirstChoiceHillClimbing extends EightQueensProblem<S,A>{

    private  EightQueensProblem<S,A> problem = new EightQueensProblem();

    public FirstChoiceHillClimbing(Problem<S,A> problem, , , ) {  // This code should not be in a constructor. -Fry
        current = new Node(initialState, -1, problemHeruistic);  // why does  node need the heuristic function? -Fry
        Node neighbor;
        ArrayList temp;  // Use ArrayList<A>, no? -Fry
        ArrayList output = new ArrayList<>();  //  Use the getSuccessors() function.
        while (true) {
            temp = problem.getSuccessors(current.state);  // State taken as parameter.  problem.getSuccessors(current.state) -Fry
            // neighbor = temp.getBestNeighbor(problem.game.getSuccessors(current.state));  // Not getting random action. -Fry
            // neighbor = new Node((char[][]) neighborTemp.get(0), (int) neighborTemp.get(1), (int) neighborTemp.get(3));  // ?? -Fry

            // Choose a random Action from temp.
            // java.util.Random random = new ....
            int randIndex = random.nextInt(temp.size())
            // temp[randInxdex] will be a random neighbor

            for (int i = 0; i < temp.size(); i++) {
                ArrayList stateTemp = neighbor.moveOneStep(successorTemp, i);
                if ((int) stateTemp.get(3) < current.value) {
                    neighbor = new Node((char[][]) stateTemp.get(0), (int) stateTemp.get(1), (int) stateTemp.get(3));  // ?? -Fry
                    break;
                }
                current = neighbor;
                cost++;
            }
        }
    }


}
}
