
setwd(paste0(Sys.getenv('CS_HOME'),'/SimulationModels/Models/EmergenceSystemsOfCities/openmole'))

library(dplyr,warn.conflicts = F)
library(readr)
library(ggplot2)

source(paste0(Sys.getenv('CS_HOME'),'/Organisation/Models/Utils/R/plots.R'))


# Innovation params and indics
#params<-c("macroGravityDecay","macroInnovationDecay","mesoCrossOverProba","mesoMutationProba",
#          "mesoInteractionProba","mesoToMacroInnovationThreshold","macroToMesoCrossoverMaxUpdate",
#          "macroToMesoExchangeMaxUpdate","macroToMesoMutationMaxUpdate")
#indics<-c("macroDiversity", "macroInnovation", "macroUtility", "mesoDiversity", "mesoFitness",
#  "deltaDiversity","deltaUtility","gammaDiversity","gammaUtility","psiUtility","psiDiversity")


# pse

#res <- read_csv(file=paste0('pse/20230314_084046_PSE/population138.csv'),col_names = T)
res <- read_csv(file=paste0('pse/20230314_084046_PSE/population10000.csv'),col_names = T)

resdir = paste0(Sys.getenv('CS_HOME'),'/UrbanEvolution/Results/InnovationMultiscale/pse/20230314_084046_PSE/');dir.create(resdir,recursive = T)


g=ggplot(res,aes(x=psiUtility,y=deltaUtility,color=gammaUtility,size=mesoToMacroInnovationThreshold...8))
g+geom_point(alpha=0.6)+xlab("Psi(utility)")+ylab("Delta(utility)")+
  scale_size_continuous(name=expression(theta))+scale_colour_continuous(name=expression(Gamma))+stdtheme
ggsave(filename = paste0(resdir,"pse-psi-delta-utility_colorGamma_sizetheta.png"),width=23,height=20,units='cm')






