# Running w/ full configuration
```yaml
spring:
  profiles: full
config:
  required-property: this-is-required
  optional-property: this-is-optional
  more-required-config:
    property: this-is-required
  more-optional-config:
    property: this-is-optional
``` 
```bash
$ ./mvnw clean spring-boot:run -Dspring.profiles.active=full
...
2019-02-19 21:08:16.288  INFO 28484 --- [main] i.g.m.o.ConfigLogger: Config(requiredProperty=this-is-required, optionalProperty=Optional[this-is-optional], moreRequiredConfig=MoreConfig(property=this-is-required), moreOptionalConfig=Optional.empty)
```
* The field `optionalProperty` of type `Optional<String>` gets assigned as expected.
* The field `moreOptionalConfig` of type `Optional<MoreConfig>` remains `Optional.empty`. This is not expected. It is expected to be `MoreConfig(property=this-is-optional)`.

# Running w/ minimal configuration 
```yaml
spring:
  profiles: minimal
config:
    required-property: this-is-required
    more-required-config:
      property: this-is-required
```
```bash
$ ./mvnw clean spring-boot:run -Dspring.profiles.active=minimal
...
2019-02-19 21:09:01.393  INFO 28511 --- [main] i.g.m.o.ConfigLogger: Config(requiredProperty=this-is-required, optionalProperty=Optional.empty, moreRequiredConfig=MoreConfig(property=this-is-required), moreOptionalConfig=Optional.empty)
```
* The field `optionalProperty` of type `Optional<String>` remains `Optional.empty` as expected.
* The field `moreOptionalProperty` of type `Optional<MoreConfig>` remains `Optional.empty` as expected.
