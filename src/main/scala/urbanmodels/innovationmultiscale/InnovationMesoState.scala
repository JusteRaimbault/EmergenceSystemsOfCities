package urbanmodels.innovationmultiscale

case class InnovationMesoState(firms: Seq[MesoInnovationCluster.Firm],
                               interactionIntensity: Double,
                               time: Int)
