public class InMemoryLuckControl implements LuckControl {

    private final double MAGICAL_NUMBER = 7;
    private final double LOSING_PROBABILITY = 10;

    @Override
    public boolean hasLostLuck() {
        double newTry = Math.ceil(Math.random() * LOSING_PROBABILITY);
        return newTry == MAGICAL_NUMBER;
    }
}
