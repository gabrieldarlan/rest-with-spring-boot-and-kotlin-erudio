package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

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


    fun findAll(): List<Person> {
        logger.info("Finding one person!")

        return mutableListOf(
            Person(
                id = counter.incrementAndGet(),
                firstName = "MUSTARD",
                lastName = "MUSTARD",
                address = "Japão",
                gender = "male"
            ),
            Person(
                id = counter.incrementAndGet(),
                firstName = "REIKO ",
                lastName = "YANAGI",
                address = "Japão",
                gender = "female"
            ),
            Person(
                id = counter.incrementAndGet(),
                firstName = "MOE",
                lastName = "Darlan",
                address = "KAMIJI",
                gender = "female"
            ),
        )
    }



}