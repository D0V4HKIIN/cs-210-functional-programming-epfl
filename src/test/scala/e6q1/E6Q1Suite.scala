/* Copyright 2022 EPFL, Lausanne */

package e6q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E6Q1Suite extends munit.FunSuite:

  import E6Q1._
  import E6Q1SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case TrianglesWorksOnSimpleGraph(_, _, descr, pts) =>
          s"Triangles works on $descr ($pts pts)"
        case TrianglesTranslatedWorksOnSimpleGraph(_, _, descr, pts) =>
          s"Triangles translated works on $descr ($pts pts)"
    
    def msg: String =
      t match
        case TrianglesWorksOnSimpleGraph(_, _, descr, pts) =>
          s"Wrong result for $descr"
        case TrianglesTranslatedWorksOnSimpleGraph(_, _, descr, pts) =>
          s"Wrong result for $descr"
      
    def existsOnce(res: List[(NodeId, NodeId, NodeId)], exp: List[List[(NodeId, NodeId, NodeId)]]): Boolean =
      res.size == exp.size && exp.forall(ls => ls.exists(p => res.contains(p)))

    def execute: Unit =
      t match
        case t: TrianglesWorksOnSimpleGraph =>
          assertEquals(existsOnce(triangles(t.arg.toList), t.exp.toList.map(_.toList)), true, t.msg)
        case tt: TrianglesTranslatedWorksOnSimpleGraph =>
          assertEquals(existsOnce(trianglesTranslated(tt.arg.toList), tt.exp.toList.map(_.toList)), true, tt.msg)
      
  allTests.foreach(t =>
    test(t.title) { t.execute}  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")