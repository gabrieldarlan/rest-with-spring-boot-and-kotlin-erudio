package br.com.erudio.mapper.custom

import br.com.erudio.data.vo.v2.PersonVO
import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {
    fun mapEntityToVO(person: Person): PersonVO = PersonVO(
        id = person.id,
        address = person.address,
        birthDay = Date(),
        firstName = person.firstName,
        lastName = person.lastName,
        gender = person.gender,
    )

    fun mapVOToEntity(person: PersonVO) = Person(
        id = person.id,
        address = person.address,
        firstName = person.firstName,
        lastName = person.lastName,
        gender = person.gender,
    )



}