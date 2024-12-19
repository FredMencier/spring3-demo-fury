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

# branch fury-ser
- Add custom converter FuryMessageConverter to serialize/deserialize object in place of json
- Manual register objects in fury bean with FuryConfig
- Test fury communication between SpringFuryClient and SpringFuryServer

# branch fury-ser-annotation
- Ajout d'une annotation @FurySerializer permettant de réaliser le register
- Ajout d'un mediaType fury, *+fury afin de supporter json et fury
- Ajout d'un check du supports dans FuryMessageConverter