; These are our helper functions

(define exponential
  (lambda (base power)(
      if (= power 0)
      1
      (* base (exponential base (- power 1)))
    )
  )
)

(display (exponential -1 1)) ; -
(newline)
(display (exponential -1 0)) ; -1
(newline)
(display (exponential 5 2)) ; 5^2
(newline)

(define factorial
  (lambda (n)(
    if(= n 0)
    1
    (* n (factorial (- n 1)))
    )
  )
)

(display (factorial 6)) ; 720
(newline)

; These are our main functions

(define term ( 
    lambda( x i) (* (/ (exponential -1 i) (factorial (+ (* 2 i) 1)) ) (exponential x (+ (* 2 i) 1)))
  )
)

; testing term function

(display (+ (term 5 0) (term 5 1))) ; -15.8333333... which is what we expected
(newline)

(define PI 3.14)

(define sum-of-term
  (lambda( radian iteration) ( 
                if (<= iteration -1)
                0
                (+ (term radian iteration) (sum-of-term radian (- iteration 1)))
              )
  )
)

(display "sum-of-term results \n")
(display (sum-of-term (/ PI 2) 1) )
(newline)
(display (sum-of-term (/ PI 2) 5) )
(newline)
(display (sum-of-term (/ PI 2) 10) )
(newline)
(display (sum-of-term PI 1) )
(newline)
(display (sum-of-term PI 5) )
(newline)
(display (sum-of-term PI 10) ) 
(newline)

;sum-of-term results 
;0.9250178333333334
;0.9999996270418703
;0.9999996829318349
;-2.019857333333333
;0.0011503970403433502
;0.0015926529267152592

(define sum-of-term-tr
  (lambda (radian iteration accumulator) (
    if (<= iteration -1)
    accumulator
    (sum-of-term-tr radian (- iteration 1) (+ accumulator (term radian iteration)))
    )
  )
)

(display "sum-of-term-tr results \n")
(display (sum-of-term-tr (/ PI 2) 1 0) )
(newline)
(display (sum-of-term-tr (/ PI 2) 5 0) )
(newline)
(display (sum-of-term-tr (/ PI 2) 10 0) )
(newline)
(display (sum-of-term-tr (/ PI 2) 1 0) )
(newline)
(display (sum-of-term-tr (/ PI 2) 5 0) )
(newline)
(display (sum-of-term-tr PI 10 0))
(newline)

;sum-of-term-tr results 
;0.9250178333333334
;0.9999996270418701
;0.9999996829318347
;0.9250178333333334
;0.9999996270418701
;0.0015926529267153988

(require racket/trace)
(trace sum-of-term)
(trace sum-of-term-tr)

(sum-of-term (/ PI 2) 10)
(sum-of-term-tr (/ PI 2) 10 0)