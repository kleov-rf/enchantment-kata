import java.util.*;

public class InMemoryMagicBook implements MagicBook {

    private final LuckControl luckControl;
    private final EnchantmentRepository enchantmentRepository;
    private double LAST_SPELL_CASTED_POSITION;

    public InMemoryMagicBook() {
        this.luckControl = new InMemoryLuckControl();
        this.enchantmentRepository = new EnchantmentRepository();
    }

    public InMemoryMagicBook(LuckControl luckControl) {
        this.luckControl = luckControl;
        this.enchantmentRepository = new EnchantmentRepository();
    }

    @Override
    public Enchantment castSpell() {
        if (luckControl.hasLostLuck()) return null;

        double newEnchantmentPosition = lookForNewSpell();

        List<String> enchantmentsSpells = enchantmentRepository.retrieveSpellings();
        String newSpell = enchantmentsSpells.get((int) newEnchantmentPosition);

        return enchantmentRepository.exposeEnchantment(newSpell);
    }

    private double lookForNewSpell() {
        double newEnchantmentPosition;

        do {
            newEnchantmentPosition = Math.floor(Math.random() * enchantmentRepository.retrieveSpellings().size());
        } while (newEnchantmentPosition == LAST_SPELL_CASTED_POSITION);

        LAST_SPELL_CASTED_POSITION = newEnchantmentPosition;
        return newEnchantmentPosition;
    }
}
