package br.com.erudio.services

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.exceptions.ResourceNotFoundOperationException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding persons!")
        return repository.findAll().let {
            DozerMapper.parseListObjects(it, PersonVO::class.java)
        }
    }

    fun findById(id: Long): PersonVO? {
        logger.info("Finding one person!")
        return repository.findById(id).orElseThrow {
            ResourceNotFoundOperationException("No records found for this ID.")
        }.run {
            DozerMapper.parseObject(this, PersonVO::class.java)
        }
    }

    fun create(personVO: PersonVO): PersonVO {
        logger.info("Creating one person with name ${personVO.firstName}!")
        return DozerMapper.parseObject(personVO, Person::class.java).run {
            DozerMapper.parseObject(repository.save(this), PersonVO::class.java)
        }

    }

    fun update(person: PersonVO): PersonVO {
        return repository.findById(person.id)
            .orElseThrow { ResourceNotFoundOperationException("No records found for this id") }.copy(
                firstName = person.firstName,
                lastName = person.lastName,
                address = person.address,
                gender = person.gender
            ).let {
                DozerMapper.parseObject(repository.save(it), PersonVO::class.java)
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