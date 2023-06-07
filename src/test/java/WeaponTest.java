import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeaponTest {

    @Test
    void should_cast_spell_from_magic_book_when_wanting_to_enchant() {
        MagicBook magicBook = spy(MagicBook.class);
        Weapon weapon = new Weapon(magicBook);

        weapon.enchant();

        verify(magicBook, atLeastOnce()).castSpell();
    }

    @Test
    void should_set_enchantment_when_casting_spell_from_magicbook() {
        MagicBook magicBook = mock(MagicBook.class);
        Weapon weapon = new Weapon(magicBook);

        Enchantment expectedEnchantment = new Enchantment("Icy", "+5 ice damage");
        when(magicBook.castSpell()).thenReturn(expectedEnchantment);

        weapon.enchant();

        assertEquals(expectedEnchantment, weapon.enchantment);
    }

    @Test
    void should_describe_weapon_stats() {
        // arrange
        MagicBook magicBook = mock(MagicBook.class);
        String name = "Dagger of the Nooblet";
        String firstSkill = "5 - 10 attack damage";
        String secondSkill = "1.2 attack speed";
        Weapon weapon = new Weapon(name, List.of(firstSkill, secondSkill), magicBook);

        // act
        String actualWeaponStats = weapon.describe();

        // assert
        String expectedStats = "Dagger of the Nooblet\n5 - 10 attack damage\n1.2 attack speed";
        assertEquals(expectedStats, actualWeaponStats);
    }

    @Test
    void should_describe_weapon_stats_included_enchantment() {
        // arrange
        MagicBook magicBook = mock(MagicBook.class);
        String name = "Dagger of the Nooblet";
        String firstSkill = "5 - 10 attack damage";
        String secondSkill = "1.2 attack speed";
        Weapon weapon = new Weapon(name, List.of(firstSkill, secondSkill), magicBook);

        when(magicBook.castSpell()).thenReturn(new Enchantment("Icy", "+5 ice damage"));

        // act
        weapon.enchant();
        String actualWeaponStats = weapon.describe();

        // assert
        String expectedStats = "Icy Dagger of the Nooblet\n5 - 10 attack damage\n1.2 attack speed\n+5 ice damage";
        assertEquals(expectedStats, actualWeaponStats);
    }
}