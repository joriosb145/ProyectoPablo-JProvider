package cr.ac.utn.jprovider.domain.model

data class Provider(
    val id: String,
    val name: String,
    val contactPerson: String,
    val email: String,
    val phoneNumber: String,
    val address: String
)


