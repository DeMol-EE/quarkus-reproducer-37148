# Reproducer for [#37148](https://github.com/quarkusio/quarkus/issues/37148)

This is a reproducer for an issue with JAX-RS sub resources in combination with Quarkus' native compilation.

## Working flow

1. `mvn quarkus:dev`
2. `curl http://localhost:8080/hello/foo?bar=5`
3. Receive response "Hello foo 5"

## Broken flow

1. `docker build -t reproducer-37148 .`
2. `docker run --rm -p 8080:8080 reproducer-37148`
3. `curl http://localhost:8080/hello/foo?bar=5`
4. Observe an error
