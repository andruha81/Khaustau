package battle.api.services;

public interface IChampionship {

    void start(int numberOfFighters);

    void startCombats();

    boolean checkWinner();

    void printResults();

}
