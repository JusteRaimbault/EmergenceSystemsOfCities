package urbanmodels.mesomacromultiscale

import urbanmodels.utils.GridMorphology
import urbanmodels.utils.Statistics

trait MesoState {
  def time: Int
  def populationGrid: Vector[Vector[Double]]

  def morphology: (Double,Double,Double,Double,Double) = {
    val pop = populationGrid.map{_.toArray}.toArray
    val s = Statistics.slope(pop.flatten)
    (GridMorphology.moran(pop),GridMorphology.distanceMean(pop),Statistics.entropy(pop),s._1,s._2)
  }

}