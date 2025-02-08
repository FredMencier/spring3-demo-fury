docker run \
    -it \
    --rm \
    -v /Users/fredericmencier/Projects/spring3-demo-fury/hyperfoil:/benchmarks:Z \
    -v /Users/fredericmencier/Projects/spring3-demo-fury/hyperfoil/reports:/tmp/reports:Z \
    quay.io/hyperfoil/hyperfoil \
    run -o /tmp/reports /benchmarks/searchScenarioFury.yml