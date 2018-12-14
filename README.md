# FactorialGuesser
Simple test task, with tests and docs

Guesses the n by it's n! (n factorial) value. Magic! ^_^
Stays strong with any input.\
Supports reeaaally big numbers. 
E.g. try this: 55745857612076058813234317117419771556272886109483581752463927935846946310374691578057284710599874844234646982443450754604453404911734348832487342619913750049708004343808000000000000000000000000000\
And then try it again - see the reduced calculation time, difference should be about 98% 

### Please note! There are multiple solutions included inside
- 'Brute force' solution: multiplying 1 by 1, 2, 3, etc. try to get enough to fit the provided factorial
- 'Reverse' simple solution: dividing provided factorial by 1, 2, 3, etc., the correct n is when we get 1
- 'Smart brute force' solution: saving all the calculated factorials in order to increase the speed of next calculations