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
  - case 1 :
    - FuryServer and FuryClient use JavaObjectLib direct dependency with same version 1.0.0-SNAPSHOT
  - case 2 :
    - FuryServer use version 1.1.0-SNAPSHOT (add description to AccountDto)
    - FuryClient use version 1.0.0-SNAPSHOT

# branch fury-ser-annotation
- Ajout d'une annotation @FurySerializer permettant de réaliser le register
- Ajout d'un mediaType fury, *+fury afin de supporter json et fury
- Ajout d'un check du supports dans FuryMessageConverter