class Human{
    var name: String? = null
    var age: Int? = null
}

class Castle{
    var habitants:MutableList<Human> = mutableListOf()
    var name = ""
}

class Area{
    var castles:MutableList<Castle> = mutableListOf()
}