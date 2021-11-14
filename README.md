# fibonacci-jvm-server

This is a fun example of a perfectly functional server for computing Fibonacci numbers (small values only). This server
demonstrates my philosophical developer workflow with gRPC and Protobuf.

## Key points

### The API (proto definitions)

* It is declared in a separate GitHub repository:
  ```
  https://github.com/duckladydinh/giathuanapis.git
  ```

* It is linked to **Google APIs** using Buf (only `buf.yaml` and `buf.lock`, no `buf.gen.yaml`).

### The server (in Java)

* It is defined in a separate GitHub repository (this `fibonacci-jvm-server`).
* It consumes the API for generation-only using Buf (only `buf.gen.yaml`, NO other Buf files).
* It generates files into a separate `src/gen/java` directory.
* It generates a docker image instead of relying solely on the binary (jar).

## Assessment

### Pros
* Found a public workflow with Protobuf + gRPC without relying on Bazel and the monorepo.
* The API is declared only once can be delivered as-is to all clients and servers without copy-paste.
* We can use Gradle (Java standard) and Buf (future proto standard).

### Cons
* The generation may have to be repeated multiple times for clients and servers.
* Using Buf deps, IntelliJ cannot be used for linting and autocomplete.