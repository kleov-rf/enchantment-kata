import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InMemoryMagicBookTest {

    @Test
    void should_return_an_enchantment() {
        InMemoryMagicBook inMemoryMagicBook = new InMemoryMagicBook();

        Enchantment enchantment = inMemoryMagicBook.castSpell();

        assertNotNull(enchantment);
    }

    @Test
    void should_return_a_different_enchantment_when_called_again() {
        InMemoryMagicBook inMemoryMagicBook = new InMemoryMagicBook();

        Enchantment firstEnchantment = inMemoryMagicBook.castSpell();
        Enchantment secondEnchantment = inMemoryMagicBook.castSpell();

        assertNotEquals(firstEnchantment, secondEnchantment);
    }

    @Test
    void should_be_able_to_return_no_enchantment_when_luck_not_good() {
        // arrange
        LuckControl luckControl = mock(LuckControl.class);
        InMemoryMagicBook inMemoryMagicBook = new InMemoryMagicBook(luckControl);

        // act
        when(luckControl.hasLostLuck()).thenReturn(true);
        Enchantment actualEnchantment = inMemoryMagicBook.castSpell();

        // assert
        assertNull(actualEnchantment);
    }
}