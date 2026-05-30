package urbanmodels.mesomacromultiscale

import urbanmodels.utils.Matrix.{Dense, MatrixImplementation}
import urbanmodels.utils.{DenseMatrix, Statistics}

import scala.util.Random

object RunModel extends App {

  implicit val rng: Random = new Random(-321205711823065277L)
  implicit  val matrixImplem: MatrixImplementation = Dense(DenseMatrix.Real())

  val model = MultiscaleModel(
    timeSteps = 20,
    macroNcities = 20,
    macroInitialHierarchy = 1.0,
    macroInitialMaxPop = 100000,
    macroRange=500,
    macroGrowthRate = 0.01,
    macroInteractionDecay = 100.0,
    macroInteractionWeight=0.005,
    macroInteractionGamma=1.0,
    mesoGridSize=50,
    mesoCenterDensity=1000,
    mesoAlpha = 1.0,
    mesoBeta=0.05,
    mesoNdiff = 1,
    mesoTimeSteps = 10,
    macroMesoAlphaUpdateMax = 0.05,
    macroMesoBetaUpdateMax = -0.05,
    mesoMacroCongestionCost = 1.0,
    mesoMacroDecayUpdateMax = 0.05
  )

  val result = model.modelRun(true)(rng,matrixImplem)

  val (macroPopulations,macroClosenesses,macroAccessibilities,mesoMorans,mesoDistances,mesoEntropy,mesoSlopes,mesoSlopeRsquared,mesoCongestedFlows,mesoMissingPopulations):(Array[Double],Array[Double],Array[Double],Array[Double],Array[Double],Array[Double],Array[Double],Array[Double],Array[Double],Array[Double]) = result.asArrayTuple

}
