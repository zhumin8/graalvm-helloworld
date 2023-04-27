This is a vanilla GraalVM helloworld with spring boot.

`native` profile is added as instructed in https://cloud.google.com/java/docs/compile-native-images

- Run `mvn package -Pnative` to generate the native image in the ./target folder. (need to set jdk to GraalVM 22.3. With SDKMan, do `sdk install java 22.3.r17-grl` and `sdk use java 22.3.r17-grl`)

- Run the application: ` ./target/graalvm-helloworld`