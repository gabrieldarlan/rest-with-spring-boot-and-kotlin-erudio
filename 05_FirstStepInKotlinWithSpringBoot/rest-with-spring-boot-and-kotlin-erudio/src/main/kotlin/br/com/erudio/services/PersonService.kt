package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding persons!")

        val persons: MutableList<Person> = ArrayList()
        for (i in 1..7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Gabriel"
        person.lastName = "Darlan"
        person.address = "Brasil"
        person.gender = "Not found"
        return person
    }

    fun create(person: Person) = person
    fun update(person: Person) = person
    fun delete(id: Long) {}

    private fun mockPerson(i: Int) = Person(
        id = counter.incrementAndGet(),
        firstName = "John $i",
        lastName = "Doe $i",
        address = "Address $i",
        gender = "male $i"
    )


}