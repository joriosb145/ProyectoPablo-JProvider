package cr.ac.utn.jprovider.domain.repository

import cr.ac.utn.jprovider.domain.model.OrderRequest
import cr.ac.utn.jprovider.domain.model.Provider

interface IProviderRepository {
    fun getProviders(): List<Provider>
    fun getProviderById(id: String): Provider?
    fun insertProvider(provider: Provider)
    fun updateProvider(provider: Provider)
    fun deleteProvider(id: String)

    fun getOrderRequests(): List<OrderRequest>
    fun insertOrderRequest(request: OrderRequest)
}
