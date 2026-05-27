package urbanmodels.innovationmultiscale

import urbanmodels.utils.Matrix

case class InnovationMacroState(
                     time: Int,
                     populations: Matrix,
                     innovations: Seq[Matrix],
                     utilities: Seq[Double],
                     distanceMatrix: Matrix,
                     flows: Matrix
                     )


object InnovationMacroState {

}
