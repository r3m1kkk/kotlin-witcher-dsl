fun main() {

    `simple object contrusction`()

    `nested object construction`()

    `object construction using apply scope function`()

    `object construction using function literals with receivers`()

    `object construction using Type safe builders`()

}

private fun `simple object contrusction`():Village {


    val geralt = Person("Geralt", 74)
    val yennefer = Person("Yennefer", 32)
    val ciri = Person("Ciri", 15)

    val geraltsHouse = House(listOf(geralt, yennefer, ciri))

    val vesemir = Person("Vesemir", 99)
    val lambert = Person("Lambert", 53)
    val eskel = Person("Eskel", 43)

    val kaerMorhen = House(listOf(vesemir, lambert, eskel))

    return Village(listOf(kaerMorhen, geraltsHouse))
}

private fun `nested object construction`() =
    Village(
        listOf(
            House(
                listOf(
                    Person("Vesemir", 99),
                    Person("Lambert", 53),
                    Person("Eskel", 43)
                )
            ),
            House(
                listOf(
                    Person("Geralt", 74),
                    Person("Yennefer", 32),
                    Person("Ciri", 15)
                )
            )
        )
    )

private fun `object construction using apply scope function`() =
     Area().apply{
        castles = mutableListOf(
            Castle().apply{
                habitants = mutableListOf(
                    Human().apply{
                        name = "Vesemir"
                        age = 99
                    },
                    Human().apply {
                        name = "Lambert"
                        age = 52
                    },
                    Human().apply {
                        name = "Eslek"
                        age = 43
                    }
                )
            },
            Castle().apply{
                habitants = mutableListOf(
                    Human().apply{
                        name = "Geralt"
                        age = 74
                    },
                    Human().apply{
                        name = "Yennefer"
                        age = 32
                    },
                    Human().apply{
                        name = "Ciri"
                        age = 15
                    }
                )
            }
        )
    }


private fun `object construction using function literals with receivers`() {
//  made with function literals with receiver
//    return area {
//        castles = mutableListOf(
//            castle {
//                habitants = mutableListOf(
//                    human {
//                        name = "Vesemir"
//                        age = 99
//                    },
//                    human {
//                        name = "Lambert"
//                        age = 52
//                    },
//                    human{
//                        name = "Eslek"
//                        age = 43
//                    }
//                )
//            },
//            castle {
//                habitants = mutableListOf(
//                    human {
//                        name = "Geralt"
//                        age = 74
//                    },
//                    human {
//                        name = "Yennefer"
//                        age = 32
//                    },
//                    human {
//                        name = "Ciri"
//                        age = 15
//                    }
//                )
//            }
//        )
//    }
}

private fun `object construction using Type safe builders`() =
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
            //not allowed in this scope, thanks to DslMarker
            /*
            castle {
                human {
                    name = "Enemy tries to build a castle inside our castle!"
                }
            }*/
        }
    }
