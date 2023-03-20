# DSL in Kotlin using Type-safe builders

This code shows how to compose strongly-typed objects using friendly, JSON similar syntax:

```kotlin
area {
    castle {
        name = "Kaer Mohren"
        human {
            name = "Vesemir"
            age = 99
        }
        human {
            name = "Lambert"
            age = 52
        }
        human{
            name = "Eslek"
            age = 43
        }
    }
    castle {
        name = "Geralt's house"
        human {
            name = "Geralt"
            age = 74
        }
        human {
            name = "Yennefer"
            age = 32
        }
        human {
            name = "Ciri"
            age = 15
        }
    }
}
```

Done using Kotlin's Type-safe builders https://kotlinlang.org/docs/type-safe-builders.html

[witcherDsl.kt - contains builders definition](src/main/kotlin/witcherDsl.kt)