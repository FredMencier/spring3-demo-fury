# spring3-demo-fury

Demo project Apache Fury : https://fury.apache.org/

3 projects :
- SpringFuryServer (localhost:8081)
  - provide http rest endpoint /accounts/search?accountNo=xxx
  - return an AccountDto java object
- SpringFuryClient (localhost:8082)
  - call server endpoint /accounts/search
  - receive an AccountDto

# branch main
- classic json communication between SimpleFuryServer and SimpleFuryClient

#