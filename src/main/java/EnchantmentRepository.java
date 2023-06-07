import java.util.*;

public class EnchantmentRepository {
    private final Map<String, Enchantment> availableEnchantments;

    public EnchantmentRepository() {
        this.availableEnchantments = new HashMap<>() {{
            put("ice", new Enchantment("Icy", "+5 ice damage"));
            put("fire", new Enchantment("Inferno", "+5 fire damage"));
            put("lifesteal", new Enchantment("Vampire", "+5 lifesteal"));
            put("agility", new Enchantment("Quick", "+5 agility"));
            put("strength", new Enchantment("Angry", "+5 strength"));
        }};
    }

    public EnchantmentRepository(HashMap<String, Enchantment> availableEnchantments) {
        this.availableEnchantments = availableEnchantments;
    }

    public List<String> retrieveSpellings() {
        return new ArrayList<>(availableEnchantments.keySet());
    }

    public Enchantment exposeEnchantment(String spell) {
        return this.availableEnchantments.get(spell);
    }
}