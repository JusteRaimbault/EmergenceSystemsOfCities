package urbanmodels.micromesomultiscale

import scala.util.Random

object TestMultiscaleMicro extends App {

  MultiscaleMicro.visualize(
   MultiscaleMicro(
      worldSize = 10,
      nCenters = 3,
      mesoStepInterval = 5,
      steps = 1,
      seed = (new Random).nextLong(),
      transportationLinkSpeed = 5.0,
      developersNumber = 5,
      developerSetupMode = "uniform"
    ).run()
  )
}
