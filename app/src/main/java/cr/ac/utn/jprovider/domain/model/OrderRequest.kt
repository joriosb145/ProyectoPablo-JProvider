package cr.ac.utn.jprovider.domain.model

import java.util.Date

data class OrderRequest(
    val id: String,
    val providerId: String,
    val title: String,
    val dueDate: Date,
    val message: String,
    val attachment: String?
)


