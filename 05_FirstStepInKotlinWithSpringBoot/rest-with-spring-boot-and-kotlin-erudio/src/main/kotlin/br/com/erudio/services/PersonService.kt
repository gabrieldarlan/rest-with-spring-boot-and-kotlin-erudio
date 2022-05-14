package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundOperationException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding persons!")
        return repository.findAll()
    }

    fun findById(id: Long): Person? {
        logger.info("Finding one person!")
        return repository.findById(id).orElseThrow {
            ResourceNotFoundOperationException("No records found for this ID.")
        }
    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}!")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        return repository.findById(person.id)
            .orElseThrow { ResourceNotFoundOperationException("No records found for this id") }.copy(
                firstName = person.firstName,
                lastName = person.lastName,
                address = person.address,
                gender = person.gender
            ).let {
                repository.save(it)
            }
    }

    fun delete(id: Long) {
        repository.findById(id).orElseThrow {
            ResourceNotFoundOperationException("No records found for this ID.")
        }.let {
            repository.delete(it)
        }
    }


}