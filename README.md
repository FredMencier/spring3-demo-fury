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
This branch use the fury-spring-boot-starter : https://github.com/FredMencier/fury-starter

# repo fury-starter
- Use annotation @FuryObject to discover and register objects
- Configuration :
  - org.fury.withLanguage to define fury language
  - org.fury.scanPackages list package to scan for objects registration
- Use mediaType fury or *+fury (FuryMediaType) to use fury serialization