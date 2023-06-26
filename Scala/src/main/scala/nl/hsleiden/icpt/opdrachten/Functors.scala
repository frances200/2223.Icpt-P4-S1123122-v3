package nl.hsleiden.icpt.opdrachten

import nl.hsleiden.icpt.opdrachten.ExceptionHandling.{appendHi, division, maakNegatief}

object Functors {


  /**
   * Doe hier een dubbele divisie.
   * Eerst lh / rh (resultaat)
   * lh / resultaat
   * Gebruik hier flatmap voor
   *
   * @param lh
   * @param rh
   * @return
   */
  def DoubleDivision(lh: Int, rh: Int): Either[String, Int] = {
    ???
  }


  /**
   * Voer de bovenstaande divisie methode uit.
   * Incrementeer dit resultaat  met 1
   *
   * @param lh
   * @param rh
   * @return
   */
  def divisionAddOne(lh: Int, rh: Int): Either[String, Int] = {
    // Gebruik hier de map functor. https://www.geeksforgeeks.org/scala-map-method/
    ???
  }

  /**
   * Voer de appendHi dubbel uit.
   * Gebruik hier de flatmap functie voor.
   *
   * @param name
   * @return
   */
  def doubleAppendHi(name: String): Either[String, String] = {
    ???
  }

  def maakNegatiefAppend1(n: Int): Option[Int] = {
    ???
  }

  /**
   * Doe de appendHi en doe dan daarna gelijk toUpperCase.
   * Gebruik hier de map functor voor.
   *
   * @param name
   * @return
   */
  def doeAppendHiMetToUpper(name: String): Either[String, String] = {
    // Hier heb je de functor map voor nodig
    ???
  }

}
