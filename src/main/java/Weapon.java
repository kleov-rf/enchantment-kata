import java.util.List;

public class Weapon {
    private final MagicBook magicBook;
    public Enchantment enchantment;
    private final String name;
    private final List<String> commonSkills;

    public Weapon(MagicBook magicBook) {
        this.magicBook = magicBook;
        this.name = "";
        this.commonSkills = List.of();
    }

    public Weapon(String name, List<String> commonSkills, MagicBook magicBook) {
        this.name = name;
        this.commonSkills = commonSkills;
        this.magicBook = magicBook;
    }

    public void enchant() {
        this.enchantment = this.magicBook.castSpell();
    }

    public String describe() {
        String weaponSkills = String.join("\n", commonSkills);
        String stats = "%s\n%s".formatted(name, weaponSkills);

        if(enchantment != null) {
            String prefix = enchantment.prefix();
            String skill = enchantment.skill();
            stats = "%s %s\n%s\n%s".formatted(prefix, name, weaponSkills, skill);
        }

        return stats;
    }
}
