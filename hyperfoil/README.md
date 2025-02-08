## Start hyperfoil cli
docker run \
-it \
--rm \
-v /Users/fredericmencier/Projects/spring3-demo-fury/hyperfoil:/benchmarks:Z \
-v /Users/fredericmencier/Projects/spring3-demo-fury/hyperfoil/reports:/tmp/reports:Z \
quay.io/hyperfoil/hyperfoil cli


## Start hyperfoil 
start-local

## Upload scenario in hyperfoil
upload /benchmarks/springFuryServer.yml

## run benchmark
run search-benchmark

## view stats result
stats

## generate html reports
report --destination=/tmp/reports