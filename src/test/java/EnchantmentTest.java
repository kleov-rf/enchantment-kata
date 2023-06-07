import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnchantmentTest {

    @Test
    void set_an_enchantment_to_a_weapon_and_set_a_different_one_when_enchanted_again() {
        MagicBook magicBook = new InMemoryMagicBook();

        String name = "Quick Dagger of the Nooblet";
        String firstSkill = "5 - 10 attack damage";
        String secondSkill = "1.2 attack speed";
        Weapon weapon = new Weapon(name, List.of(firstSkill, secondSkill), magicBook);

        weapon.enchant();
        String firstEnchantmentWeaponDescription = weapon.describe();

        weapon.enchant();
        String secondEnchantmentWeaponDescription = weapon.describe();

        assertNotEquals(firstEnchantmentWeaponDescription, secondEnchantmentWeaponDescription);
    }

    @Test
    void lose_enchantment_when_luck_is_over() {
        LuckControl luckControl = mock(InMemoryLuckControl.class);
        MagicBook magicBook = new InMemoryMagicBook(luckControl);

        String name = "Quick Dagger of the Nooblet";
        String firstSkill = "5 - 10 attack damage";
        String secondSkill = "1.2 attack speed";
        Weapon weapon = new Weapon(name, List.of(firstSkill, secondSkill), magicBook);

        when(luckControl.hasLostLuck()).thenReturn(false);
        weapon.enchant();
        Enchantment firstEnchantment = weapon.enchantment;

        when(luckControl.hasLostLuck()).thenReturn(true);
        weapon.enchant();
        Enchantment secondEnchantment = weapon.enchantment;

        assertNotEquals(firstEnchantment, secondEnchantment);
        assertNull(secondEnchantment);
    }
}
