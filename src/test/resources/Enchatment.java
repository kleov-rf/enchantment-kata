import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Enchatment {
    @Given("we have an user weapon")
    public void weHaveAnUserWeapon() {
        Weapon weapon = new Weapon()
    }

    @When("we enchant it for the first time")
    public void weEnchantItForTheFirstTime() {
    }

    @And("we enchant it for a second time")
    public void weEnchantItForASecondTime() {
    }

    @Then("the weapon should have a different enchantment that had on the first time")
    public void theWeaponShouldHaveADifferentEnchantmentThatHadOnTheFirstTime() {
    }
}
