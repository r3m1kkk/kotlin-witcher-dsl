fun main(args: Array<String>) {
    data class Person(val name: String, val age: Int)
    data class House(val people: List<Person>)
    data class Village(val houses: List<House>)


    val geralt = Person("Geralt", 74)
    val yennefer = Person("Yennefer", 32)
    val ciri = Person("Ciri", 15)

    val geraltsHouse = House(listOf(geralt, yennefer, ciri))

    val vesemir = Person("Vesemir", 99)
    val lambert = Person("Lambert", 53)
    val eskel = Person("Eskel", 43)

    val kaerMorhen = House(listOf(vesemir, lambert, eskel))

    val kedven1 = Village(listOf(kaerMorhen, geraltsHouse))

    val kedven2 = Village(
        listOf(
            House(listOf(Person("Vesemir", 99),
                Person("Lambert", 53),
                Person("Eskel", 43))),
            House(listOf(
                Person("Geralt", 74),
                Person("Yennefer", 32),
                Person("Ciri", 15))
            )
        )
    )

    println(kedven1 == kedven2)




    val kedven3 = Area()

    val vesemirWitcher = Human()
    vesemirWitcher.name = "Witcher"
    vesemirWitcher.age = 99
    val lambertWitcher = Human()
    lambertWitcher.name = "Lambert"
    lambertWitcher.age = 52
    val eskelWitcher = Human()
    eskelWitcher.name = "Eskel"
    eskelWitcher.age = 43

    val geraltWitcher = Human()
    geraltWitcher.name = "Geralt"
    geraltWitcher.age = 74
    val yenneferSourcerer = Human()
    yenneferSourcerer.name = "Yennefer"
    yenneferSourcerer.age = 32
    val ciriChild = Human()
    ciriChild.name = "Ciri"
    ciriChild.age = 15

    val kaerMorhenCastle = Castle()
    kaerMorhenCastle.habitants = mutableListOf(vesemirWitcher, lambertWitcher, eskelWitcher)

    val geraltsCastle = Castle()
    geraltsCastle.habitants = mutableListOf(geraltWitcher, yenneferSourcerer, ciriChild)

    kedven3.castles = mutableListOf(kaerMorhenCastle, geraltsCastle)

    val kedven4 = Area().apply{
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

//  made with function literals with receiver
//    val kedven5 = area {
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

    val kedven6 = area {
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
}