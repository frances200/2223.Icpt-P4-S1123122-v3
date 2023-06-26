
import nl.hsleiden.icpt.opdrachten.ExceptionHandling.{appendHi, division,  maakNegatief}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ExceptionHandlingTests  extends AnyFlatSpec with should.Matchers {


  "division" should "Division door nul moet links zijn met foutmelding 'Kan niet delen door nul'" in {
    division(1,0) should be (Left("Kan niet delen door nul"))
  }

  "division" should "Divisie moet ook werken" in {
    division(9, 3) should be (Right(9/3))
  }


  "appendHi" should "left geven met de text 'Naam is leeg' indien naam parameter leeg is" in {
    appendHi("") should be (Left("Naam is leeg"))
  }

  "AppendHi" should " hallo voor een naam zetten" in {
    appendHi("Heiko") should be (Right("hallo Heiko"))
  }


  "Maak negatief" should "None geven bij een negatief getal" in {
    maakNegatief(-1) should be (None)
  }

  "Maak negatief" should "een (Some) negatief geven bij een positief getal" in {
    maakNegatief(1) should be (Some(-1))
  }




}
