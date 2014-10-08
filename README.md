# clojure-brainfuck

Interpreter for the
[brainfuck programming language](http://www.muppetlabs.com/~breadbox/bf/)

## Usage

lein run resources/hello.bf
> Hello World!

lein run resources/fibonacci.bf
> 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89

lein run resources/sierpinski.bf
>
                                    *    
                                   * *    
                                  *   *    
                                 * * * *    
                                *       *    
                               * *     * *    
                              *   *   *   *    
                             * * * * * * * *    
                            *               *    
                           * *             * *    
                          *   *           *   *    
                         * * * *         * * * *    
                        *       *       *       *    
                       * *     * *     * *     * *    
                      *   *   *   *   *   *   *   *    
                     * * * * * * * * * * * * * * * *    
                    *                               *    
                   * *                             * *    
                  *   *                           *   *    
                 * * * *                         * * * *    
                *       *                       *       *    
               * *     * *                     * *     * *    
              *   *   *   *                   *   *   *   *    
             * * * * * * * *                 * * * * * * * *    
            *               *               *               *    
           * *             * *             * *             * *    
          *   *           *   *           *   *           *   *    
         * * * *         * * * *         * * * *         * * * *    
        *       *       *       *       *       *       *       *    
       * *     * *     * *     * *     * *     * *     * *     * *    
      *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *    
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *    

## Tests

lein test

## Documentation
http://mbuceta.github.io/clojure-brainfuck/
