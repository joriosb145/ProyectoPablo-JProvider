package cr.ac.utn.jprovider.domain.repository

import cr.ac.utn.jprovider.domain.model.OrderRequest
import cr.ac.utn.jprovider.domain.model.Provider

interface IProviderRepository {
    // Operaciones de proveedores
    fun getProviders(): List<Provider>
    fun insertProvider(provider: Provider)
    fun deleteProvider(id: String)

    // Operaciones de solicitud de pedido
    fun getOrderRequests(): List<OrderRequest>
    fun insertOrderRequest(request: OrderRequest)
}

