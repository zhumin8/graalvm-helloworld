This is simple replica of Native test error: `Could not find class [org.graalvm.junit.platform.NativeImageJUnitLauncher__ApplicationContextInitializer]`

- run tests with ` mvn clean test`, all 3 tests should succeed. 
- run tests with `mvn -PnativeTest clean test`, test should succeed.
```agsl
Test run finished after 95 ms
[         3 containers found      ]
[         0 containers skipped    ]
[         3 containers started    ]
[         0 containers aborted    ]
[         3 containers successful ]
[         0 containers failed     ]
[         3 tests found           ]
[         1 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]
```

-  Now remove `@DisabledInNativeImage` from `com.example.graalvmhelloworld.GraalvmHelloWorldApplicationTests.applicationBuilder`, run native test again, fails with:
```agsl
Failures (1):
  JUnit Jupiter:GraalvmHelloWorldApplicationTests:applicationBuilder()
    MethodSource [className = 'com.example.graalvmhelloworld.GraalvmHelloWorldApplicationTests', methodName = 'applicationBuilder', methodParameterTypes = '']
    => java.lang.IllegalArgumentException: Could not find class [org.graalvm.junit.platform.NativeImageJUnitLauncher__ApplicationContextInitializer]
       org.springframework.util.ClassUtils.resolveClassName(ClassUtils.java:333)
       org.springframework.context.aot.AotApplicationContextInitializer.instantiateInitializer(AotApplicationContextInitializer.java:80)
       org.springframework.context.aot.AotApplicationContextInitializer.initialize(AotApplicationContextInitializer.java:71)
       org.springframework.context.aot.AotApplicationContextInitializer.lambda$forInitializerClasses$0(AotApplicationContextInitializer.java:61)
       org.springframework.boot.SpringApplication.applyInitializers(SpringApplication.java:605)
       [...]
     Caused by: java.lang.ClassNotFoundException: org.graalvm.junit.platform.NativeImageJUnitLauncher__ApplicationContextInitializer
       java.base@17.0.5/java.lang.Class.forName(DynamicHub.java:1132)
       org.springframework.util.ClassUtils.forName(ClassUtils.java:283)
       org.springframework.util.ClassUtils.resolveClassName(ClassUtils.java:323)
       [...]

Test run finished after 101 ms
[         3 containers found      ]
[         0 containers skipped    ]
[         3 containers started    ]
[         0 containers aborted    ]
[         3 containers successful ]
[         0 containers failed     ]
[         3 tests found           ]
[         0 tests skipped         ]
[         3 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         1 tests failed          ]

```