# Overview
- Basically we are making a database that stores things like a Treap but we keep track of interval.  
- Closed interval = ordered pair [a, b] s.t. a <= b
    - [a, b] is the set of real numbers between a and b (inclusively)
- Interval database = Set of elements where each element x has an interval
  *x.interv*
    - Operations:
        - intervalInsert(x): adds element where *x.interv* references an interval
        - intervalSearch(x): Returns reference to x s.t. x.interv overlaps
          interval i or returns null
        - intervalDelete(x): Removal obviously
# Data Structure
- Intervals = objects -> x = [a,b].  x.low = a, x.high = b.
- Two objects, x and y (which are intervals) *overlap* if the
  intersection of the two != NULL.
    - if (i.low <= x.high && x.low <= i.high) { overlap = true }
# Interval Trichotomy
- Says that two intervals either:
  - overlap
  - one is to the left of the other (i.high < x.low)
  - one is to the right of the other (x.high < i.low)

