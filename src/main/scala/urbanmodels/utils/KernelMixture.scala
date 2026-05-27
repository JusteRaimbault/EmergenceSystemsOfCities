package urbanmodels.utils

import scala.util.Random

object KernelMixture {

  def kernelMixture(worldSize: (Int,Int),
                    centers: Either[Int,Seq[(Int,Int)]],
                    kernels: Seq[(Double,Double)=>Double],
                    rng: Random
                   ): Array[Array[Double]]
  = {
    val w = worldSize._1
    val h = worldSize._2
    val vals = Array.fill(w,h)(0.0)
    val coords = centers match {
      case Left(i) => Seq.fill(i){(rng.nextInt(w),rng.nextInt(h))}
      case Right(c) => c
    }
    for(i<- 0 until w; j<- 0 until h){
      for(c <- coords.indices){
        def k(x: Double, y: Double): Double = if (kernels.size==1) kernels.head(x,y) else kernels(c)(x,y)
        vals(i)(j) = vals(i)(j) + k(i - coords(c)._1,j - coords(c)._2)
      }
    }
    vals
  }

}

