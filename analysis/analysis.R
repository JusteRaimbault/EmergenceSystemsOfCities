
setwd(paste0(Sys.getenv('CS_HOME'),'/SimulationModels/Models/EmergenceSystemsOfCities/openmole'))

library(dplyr,warn.conflicts = F)
library(readr)
library(ggplot2)
library(scales)

source(paste0(Sys.getenv('CS_HOME'),'/Organisation/Models/Utils/R/plots.R'))


# Innovation params and indics
#params<-c("macroGravityDecay","macroInnovationDecay","mesoCrossOverProba","mesoMutationProba",
#          "mesoInteractionProba","mesoToMacroInnovationThreshold","macroToMesoCrossoverMaxUpdate",
#          "macroToMesoExchangeMaxUpdate","macroToMesoMutationMaxUpdate")
#indics<-c("macroDiversity", "macroInnovation", "macroUtility", "mesoDiversity", "mesoFitness",
#  "deltaDiversity","deltaUtility","gammaDiversity","gammaUtility","psiUtility","psiDiversity")



#########################
# PSE Innovation
resprefix = '20260530_164254_PSE-Innovation'
res <- read_csv(file=paste0('pse/',resprefix,'.csv'))

resdir = paste0('../analysis/pse/',resprefix,'/');dir.create(resdir,recursive = T)

names(res)[12:14] = c("psiUtilityAggr","deltaUtilityAggr","gammaUtilityAggr")

g=ggplot(res,aes(x=psiUtilityAggr,y=deltaUtilityAggr,color=gammaUtilityAggr,size=mesoToMacroInnovationThreshold...8))
g+geom_point(alpha=0.6)+xlab("Psi(utility)")+ylab("Delta(utility)")+
  scale_size_continuous(name=expression(theta))+
  scale_colour_gradientn(
    colors = c("red", "darkblue", "lightblue"),
    values = rescale(c(0.0, 0.05, 0.5), to = c(0, 1), from = c(0.0, 0.5)),
    limits = c(0.0, 0.5),
    name=expression(Gamma)
  )+stdtheme
ggsave(filename = paste0(resdir,"pse-psi-delta-utility_colorGamma_sizetheta.png"),width=23,height=20,units='cm')

g=ggplot(res,aes(x=psiUtilityAggr,y=deltaUtilityAggr,color=gammaUtilityAggr,size=macroToMesoCrossoverMaxUpdate...9))
g+geom_point(alpha=0.6)+xlab("Psi(utility)")+ylab("Delta(utility)")+
  scale_size_continuous(name=expression(theta))+
  scale_colour_gradientn(
    colors = c("red", "darkblue", "lightblue"),
    values = rescale(c(0.0, 0.05, 0.5), to = c(0, 1), from = c(0.0, 0.5)),
    limits = c(0.0, 0.5),
    name=expression(Gamma)
  )+stdtheme
ggsave(filename = paste0(resdir,"pse-psi-delta-utility_colorGamma_sizeMacroMesoCrossoverUpdate.png"),width=23,height=20,units='cm')




#########################
# PSE MesoMacro
resprefix = '20260531_160006_PSE-MesoMacro-Populations'
res <- read_csv(file=paste0('pse/',resprefix,'.csv'))

resdir = paste0('../analysis/pse/',resprefix,'/');dir.create(resdir,recursive = T)

names(res)[15:17] = c("psiPopulationAggr","deltaPopulationAggr","gammaPopulationAggr")

g=ggplot(res,aes(x=psiPopulationAggr,y=deltaPopulationAggr,color=gammaPopulationAggr,size=mesoMacroDecayUpdateMax...14))
g+geom_point(alpha=0.6)+xlab("Psi(population)")+ylab("Delta(population)")+
  scale_size_continuous(name=expression(delta[d]))+
  scale_colour_gradientn(
    colors = c("red", "darkblue", "lightblue"),
    values = rescale(c(0.0, 0.05, 0.5), to = c(0, 1), from = c(0.0, 0.5)),
    limits = c(0.0, 0.5),
    name=expression(Gamma)
  )+stdtheme
ggsave(filename = paste0(resdir,"pse-psi-delta-population_colorGamma_sizedeltad.png"),width=23,height=20,units='cm')




######################
# Exploration innovation

resprefix = '20260601_064724_Exploration-Innovation'
res <- read_csv(file=paste0('exploration/',resprefix,'.csv'))

resdir = paste0('../analysis/exploration/',resprefix,'/');dir.create(resdir,recursive = T)

g=ggplot(res,aes(x=macroToMesoCrossoverMaxUpdate,y=gammaUtility,color=macroToMesoExchangeMaxUpdate,group=interaction(macroToMesoExchangeMaxUpdate,macroToMesoCrossoverMaxUpdate)))
g+geom_violin()







