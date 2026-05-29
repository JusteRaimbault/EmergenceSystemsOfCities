package urbanmodels.mesomacromultiscale

import urbanmodels.utils.Matrix

/**
  * Transforms a population Sequence into a growth rate column matrix, used in macro model with additive growth process
  */
trait MacroGrowthRate {
  def growthRate: Seq[Double] => Matrix
}
