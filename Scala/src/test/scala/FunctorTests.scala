import nl.hsleiden.icpt.opdrachten.Functors.{DoubleDivision, divisionAddOne, doeAppendHiMetToUpper, doubleAppendHi, maakNegatiefAppend1}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FunctorTests extends AnyFlatSpec with should.Matchers{

  "Maak negatief append 1" should "Maak van positief getal 1 en increment deze met 1" in {
    maakNegatiefAppend1(1) should be(Some(0))
  }

  "Maak negatief append 1" should "Geef None bij een negatief getal" in {
    maakNegatiefAppend1(-1) should be(None)
  }

  "DoeAppendHiMetToUpper" should "Na een appendHi gelijk toupper doen" in {
    doeAppendHiMetToUpper("Heiko") should be(Right("HALLO HEIKO"))
  }

  "DoeAppendHiMetToUpper" should "met een lege string een left geven met 'Naam is Leeg'" in {
    doeAppendHiMetToUpper("") should be(Left("Naam is leeg"))
  }


  "divisionAddOne" should "een increment doen na divisie van twee getallen" in {
    divisionAddOne(9, 3) should be(Right((9 / 3) + 1))
  }

  "DivisionaddOne" should "Left geven met fout 'Kan niet delen door nul' bij delen door nul " in {
    divisionAddOne(1, 0) should be(Left("Kan niet delen door nul"))
  }

  "doubleAppendHi" should "Dubbel hallo zeggen " in {
    doubleAppendHi("test") should be(Right("hallo hallo test"))
  }

  "doubleAppendHi" should "bij lege waarde Naam is leeg terug geven" in {
    doubleAppendHi("") should be(Left("Naam is leeg"))
  }


  "DoubleDivision" should "Left geven met fout 'Kan niet delen door nul' bij delen door nul " in {
    DoubleDivision(1, 0) should be(Left("Kan niet delen door nul"))
  }

  "DoubleDivision" should "Right terug geven met het antwoord" in {
    DoubleDivision(9, 2) should be(Right(2))
  }
}
