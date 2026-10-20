package cr.ac.utn.jprovider.data.memory

import cr.ac.utn.jprovider.domain.model.OrderRequest
import cr.ac.utn.jprovider.domain.model.Provider
import cr.ac.utn.jprovider.domain.repository.IProviderRepository

class MemoryProviderRepository : IProviderRepository {

    private val providers = mutableListOf<Provider>()
    private val orderRequests = mutableListOf<OrderRequest>()

    init {
        // Le ponemos datos iniciales para que la lista no aparezca vacía
        providers.add(Provider("1", "Suministros del Norte", "Jose Pablo Rios", "ventas@suministrosnorte.com", "+506 6276 7884", "175 este del restaurante Hong Kong"))
        providers.add(Provider("2", "Distribuidora Central", "Carlos Mendoza", "contacto@dcentral.com", "+506 8888 8888", "San José, Costa Rica"))
        providers.add(Provider("3", "Soluciones Integrales", "Ana Porter", "hola@solucionesintegrales.com", "+506 7777 7777", "Alajuela, Costa Rica"))
    }

    override fun insertProvider(provider: Provider) {
        providers.add(provider)
    }

    override fun deleteProvider(id: String) {
        providers.removeIf { it.id.trim() == id.trim() }
    }

    override fun getProviders() = providers

    override fun getOrderRequests() = orderRequests

    override fun insertOrderRequest(request: OrderRequest) {
        orderRequests.add(request)
    }
}
