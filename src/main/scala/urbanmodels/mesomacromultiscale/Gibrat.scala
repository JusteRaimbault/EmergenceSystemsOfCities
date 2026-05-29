package urbanmodels.mesomacromultiscale
import urbanmodels.utils.Matrix

/**
  *
  * @param gibratGrowthRates city specific growth rate (endogenous self-sustained growth)
  */
case class Gibrat(
                   gibratGrowthRates: Vector[Double]
                 ) extends MacroGrowthRate {
  override def growthRate: Seq[Double] => Matrix = m =>  Matrix(gibratGrowthRates.toArray,row=false)(Matrix.defaultImplementation)
}
