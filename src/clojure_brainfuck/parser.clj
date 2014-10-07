; Parses brainfuck code using Instaparse context-free grammars parser.
; For simplicity, supposes that only brainfuck instructions are present.

(ns clojure-brainfuck.parser
    (require [instaparse.core :as insta])
  )

(def bf-parser
  (insta/parser
    "
    <expr>= (op | b)+
    <op>= (p|m|r|w|l|h)
    b = <'['> expr <']'>
    p = <'+'>
    m = <'-'>
    w = <'.'>
    r = <','>
    l = <'>'>
    h = <'<'>
    "
  )
)
(def improved-bf-parser
  (insta/parser
    "
    <expr>= (op | b)+
    <op>= (p|m|r|w|l|h)
    b = <'['> expr <']'>
    p = <'+'>
    m = <'-'>
    w = <'.'>
    r = <','>
    l = <'>'>
    h = <'<'>
    "
  )
)
