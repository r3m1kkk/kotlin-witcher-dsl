
fun human(init: Human.() -> Unit): Human{
    val h = Human()
    h.init()
    return h
}

class CastleBuilder{
    private val castleHabitants = mutableListOf<Human>()


    fun house(init: Human.() -> Unit) {
        val c = Human()
        c.init()
        castleHabitants.add(c)
    }

    fun build():Castle{
        return Castle().apply { habitants = castleHabitants }
    }
}

class AreaBuilder{
    private val areaCastles = mutableListOf<Castle>()


    fun castle(init: CastleBuilder.() -> Unit) {
        val c = CastleBuilder()
        c.init()
        areaCastles.add(c.build())
    }

    fun build():Area{
        return Area().apply { castles = areaCastles }
    }
}

fun area(init: AreaBuilder.() -> Unit): Area{
    val a = AreaBuilder()
    a.init()
    return a.build()
}

/*

fun human(init: Human.() -> Unit): Human{
    val h = Human()
    h.init()
    return h
}

fun castle(init: Castle.() -> Unit): Castle {
    val c = Castle()
    c.init()
    return c
}

fun area(init: Area.() -> Unit): Area{
    val a = Area()
    a.init()
    return a
}

 */