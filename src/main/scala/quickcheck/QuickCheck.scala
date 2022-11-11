package quickcheck

import org.scalacheck.*
import Arbitrary.*
import Gen.*
import Prop.forAll

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap:
  lazy val genHeap: Gen[H] = oneOf(
    const(empty),
    for
      k <- arbitrary[Int]
      m <- oneOf(const(empty), genHeap)
    yield insert(k, m)
  )

  given Arbitrary[H] = Arbitrary(genHeap)

  property("min1") = forAll { (a: Int) =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if isEmpty(h) then 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("minOfTwo") = forAll { (a: Int, b: Int) =>
    def minmax(a: Int, b: Int): (Int, Int) =
      if a > b then (b, a) else (a, b)
    val (min, max) = minmax(a, b)
    val heap1 = insert(a, insert(b, empty))
    val heap2 = insert(b, insert(a, empty))

    findMin(heap1) == min && findMin(heap2) == min
  }

  property("insertAndRemove") = forAll { (a: Int) =>
    isEmpty(deleteMin(insert(a, empty)))
  }

  def getList(heap: H): List[Int] =
    if isEmpty(heap) then Nil
    else findMin(heap) :: getList(deleteMin(heap))
  property("isSorted") = forAll { (heap: H) =>

    val l: List[Int] = getList(heap)
    l == l.sorted
  }

  property("minOfMeld") = forAll { (heap1: H, heap2: H) =>
    if isEmpty(heap1) && isEmpty(heap2) then true
    else
      def min(a: Int, b: Int): Int =
        if a > b then b else a

      def getMin(heap1: H, heap2: H): Int =
        if isEmpty(heap1) then findMin(heap2)
        else if isEmpty(heap2) then findMin(heap1)
        else min(findMin(heap1), findMin(heap2))

      val m = getMin(heap1, heap2)

      val heapA = meld(heap1, heap2)
      val heapB = meld(heap2, heap1)

      findMin(heapA) == m && findMin(heapB) == m
  }

  property("tripleMeld") = forAll { (heap1: H, heap2: H, heap3: H) =>
    getList(meld(meld(heap1, heap2), heap3)) == getList(
      meld(heap1, meld(heap2, heap3))
    )
  }
