package com.example.familytree

class Person constructor(val name: String, val age: Int, val mother: Person?, val father: Person?) {
    var siblings: MutableList<Person> = mutableListOf<Person>()
    var numberOfRelatives = 0

    fun addSiblings (person: Person) {
        if ( person !in siblings ) {
            siblings.add(person)
        }
    }

    /**
     * Определяет степень родства
     * на основании которого определяется принадлежность человека к братьям и сестрам текущего
     * Сейчас только родные братья и сестры (так же кровные)
     */
    fun isSibling(person: Person) : Boolean {
        if (person.mother != null && person.father != null) {
            return person.mother == this.mother || person.father == this.father
        }
        return false
    }

    fun removeSiblings(person: Person) {
        siblings.remove(person)
    }

    override fun toString(): String {
        return "$name, age $age, mother: ${mother?.let { it.name }}, father: ${father?.let { it.name }}, siblings: ${siblings.map { it.name }}"
    }


    /**
     * Идея заключалась в следующем:
     * Можно создать как отдельную личность, просто через конструктор,
     * так и создавать семью через Family
     */
    companion object Family {
        var myFamily: MutableList<Person> = mutableListOf<Person>()

        fun createFamilyGuy(name: String, age: Int, mother: Person?, father: Person?) : Person {
            val newPerson = Person (name, age, mother, father)

            val familySize = myFamily.size
            for (someoneFromFamily in myFamily) {
                someoneFromFamily.numberOfRelatives = familySize
                if (someoneFromFamily.isSibling(newPerson)) {
                    newPerson.addSiblings(someoneFromFamily)
                    someoneFromFamily.addSiblings(newPerson)
                }
            }

            newPerson.numberOfRelatives = familySize
            myFamily.add(newPerson)
            return newPerson
        }
    }
}