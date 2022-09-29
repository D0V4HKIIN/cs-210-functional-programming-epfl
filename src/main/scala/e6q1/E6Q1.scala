/* Copyright 2022 EPFL, Lausanne */

package e6q1

object E6Q1:

  type NodeId = Int
  type DirectedEdge = (NodeId, NodeId)
  type DirectedGraph = List[DirectedEdge]

  /**
    *
    * @param edges a list of pairs of integers
    * @return all cycles of length 3 in the graph described by `edges` (each cycle should appear only once)
    */
  def triangles(edges: DirectedGraph): List[(NodeId, NodeId, NodeId)] = ???

/**
    *
    * @param edges a list of pairs of integers
    * @return all cycles of length 3 in the graph described by `edges` (each cycle should appear only once)
    */
  def trianglesTranslated(edges: DirectedGraph): List[(NodeId, NodeId, NodeId)] = ???
