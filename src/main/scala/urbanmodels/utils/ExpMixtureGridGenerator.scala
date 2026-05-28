package urbanmodels.utils

import scala.math.*
import scala.util.Random


/**
  *
  * @param size grid size
  * @param centers Number of centers
  * @param maxValue Value of the exp at 0
  * @param kernelRadiuses Radiuses of the exp kernel
  * @param centerCoordinates optional coordinates of centers
  */
case class ExpMixtureGridGenerator(
                        size: (Int,Int),
                        centers: Int,
                        maxValue: Double,
                        kernelRadiuses: Seq[Double],
                        centerCoordinates: Seq[(Double,Double)] = Seq.empty
                        ) {

  def generateGrid(implicit rng: Random): Array[Array[Double]] = {
    def kernel(kernelRadius: Double)(x: Double, y: Double): Double = maxValue*exp(-sqrt(pow(x,2.0)+pow(y,2.0))/kernelRadius)
    val expKernels: Seq[(Double,Double)=> Double] = kernelRadiuses.map(kernel)
    val eithcenters = centerCoordinates.size match {case 0 => Left(centers);case _ => Right(centerCoordinates.map(c => (c._1.toInt,c._2.toInt)))}
    KernelMixture.kernelMixture(size,eithcenters,expKernels,rng)
  }


}




object ExpMixtureGridGenerator {

  /**
    * Generate one exponential kernel mixture grid
    *
    * @param gridSize grid size
    * @param nCenters centers
    * @param maxValue max value
    * @param kernelRadius kerbel radius
    * @param rng random
    * @return
    */
  def expMixtureGrid1D(gridSize: Int, nCenters: Int, maxValue: Double, kernelRadius: Double, rng: scala.util.Random): Array[Array[Double]] = {
    val arrayVals = Array.fill[Double](gridSize, gridSize) {
      0.0
    }
    val centers = Array.fill[Int](nCenters, 2) {
      rng.nextInt(gridSize)
    }
    for (i <- 0 until gridSize; j <- 0 until gridSize) {
      for (c <- 0 until nCenters) {
        arrayVals(i)(j) = arrayVals(i)(j) + maxValue * math.exp(-math.sqrt(math.pow(i - centers(c)(0), 2) + math.pow(j - centers(c)(1), 2)) / kernelRadius)
      }
    }
    arrayVals
  }


}

