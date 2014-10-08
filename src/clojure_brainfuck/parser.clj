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

; Optional parser taking into account whitespaces
; It's more complex but throws better error messages than the bf-parser
(def optional-bf-parser
  (insta/parser
    "
    <expr>=  (<whitespace> op <whitespace> | <whitespace> b <whitespace>)+
    <op>= (p|m|r|w|l|h)
    <whitespace> = #'\\s*'
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
