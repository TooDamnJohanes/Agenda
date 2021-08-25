package business

import entity.ContactEntity
import repository.ContactRepository
import java.lang.Exception

class ContactBusiness(){
    private fun validate(name: String, phone: String)
    {
        if(name == "")
        {
            throw Exception("Nome é Obrigatório!")
        }

        if(phone == "")
        {
            throw Exception("Telefone é Obrigatório!")
        }
    }

    fun getContactCountDescription(): String{
        val list = getlist()
        if(list.isEmpty())
        {
            return "0 Contatos"
        }
        else if(list.size == 1)
        {
            return "1 Contato"
        }
        else
        {
            return ("${list.size} Contatos")
        }
    }

    private fun validateDelete(name: String, phone: String) {
        if(name == "" || phone == "")
        {
            throw Exception("Selecione um contato!")
        }
    }

    fun save(name: String, phone: String) {
        validate(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository.delete(contact)
    }

    fun getlist(): List<ContactEntity> {
        return ContactRepository.getList()
    }

}