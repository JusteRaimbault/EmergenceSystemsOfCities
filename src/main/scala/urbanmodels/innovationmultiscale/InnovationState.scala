package urbanmodels.innovationmultiscale

import scala.util.Random

case class InnovationState(
                  time: Int,
                  macroState: InnovationMacroState,
                  mesoStates: Seq[Seq[InnovationMesoState]],
                  rng: Random,
                  macroModel: MacroUrbanEvolution,
                  mesoModels: Seq[MesoInnovationCluster]
                )

object InnovationState {

}