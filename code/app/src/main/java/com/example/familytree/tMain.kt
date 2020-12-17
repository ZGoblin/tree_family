package com.example.familytree

fun getMe(): Person {
    val motherOfMyMother = Person.createFamilyGuy("Sveta Lopatnichenko", 82, null, null)
    val fatherOfMyMother = Person.createFamilyGuy("Ivan Lopatnichenko", 88, null, null)

    val motherOfMyFather = Person.createFamilyGuy("Ludmila Zaets", 85, null, null)
    val fatherOfMyFather = Person.createFamilyGuy("Petro Zaets", 90, null, null)

    val mother = Person.createFamilyGuy("Lilia Zaets", 40, motherOfMyMother, fatherOfMyMother)
    val father = Person.createFamilyGuy("Sergeii Zaets", 43, motherOfMyFather, fatherOfMyFather)

    Person.createFamilyGuy("Zoya Gradiskaya", 50, motherOfMyMother, fatherOfMyMother)
    Person.createFamilyGuy("Sergeii Lopatnichenko", 48, motherOfMyMother, fatherOfMyMother)

    val itsMe = Person.createFamilyGuy("Oleg Zaets", 20, mother, father)
    Person.createFamilyGuy("Dima Zaets", 14, mother, father)

    return itsMe
}

fun print(person: Person) {
    println("Person: ${person.name}, ${person.age}")
    println("Mother: ${person.mother?.name}, ${person.mother?.age}")
    println("Father: ${person.father?.name}, ${person.father?.age}")
    println("Siblings: ${person.siblings}")
    println("***************************")
    if (person.mother != null) print(person.mother)
    if (person.father != null) print(person.father)
}

fun main() {
    val itsMe = getMe()

    print(itsMe)
    println("Family size: ${itsMe.numberOfRelatives}")
}