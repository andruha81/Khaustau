package battle.api.services;

public interface IChampionship {

    void start(int numberOfFighters);

    void startCombat();

    boolean checkWinner();

    void printResults();

}
