package urbanmodels.utils

import org.jgrapht._
import org.jgrapht.graph.{DefaultWeightedEdge, SimpleWeightedGraph}

import scala.jdk.CollectionConverters._

object GraphConversions {

  /**
    * Note: the converted jgraph does not have spatial attributes
    * FIXME take into account directed graphs
    * @param network
    * @param linkWeight
    * @return
    */
  def networkToJGraphT(network: Network, linkWeight: Link => Double = _.weight): (org.jgrapht.Graph[Int,DefaultWeightedEdge],Map[Int,Node],Map[(Int,Int),Link]) = {
    val g = new SimpleWeightedGraph[Int,DefaultWeightedEdge](classOf[DefaultWeightedEdge]) // mutable graph !
    //println(network)
    network.links.foreach{ l =>
      //println(l.e1.id+" - "+l.e2.id)
      Graphs.addEdgeWithVertices(g,l.e1.id,l.e2.id,linkWeight(l))
    }
    // ! add unconnected nodes
    network.nodes.foreach{ n =>
      if(!g.containsVertex(n.id)) g.addVertex(n.id)
    }
    val nodeMap = network.nodes.map{n=>(n.id,n)}.toMap
    val linkMap = network.links.map{l => ((l.e1.id,l.e2.id),l)}.toMap
    assert(g.vertexSet().size()==network.nodes.size,s"Missing vertices in converted graph: ${network.nodes.map(_.id).diff(g.vertexSet().asScala)}")
    (g,nodeMap,linkMap)
  }




}
