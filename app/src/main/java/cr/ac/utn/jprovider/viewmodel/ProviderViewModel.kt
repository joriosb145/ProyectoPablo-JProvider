package cr.ac.utn.jprovider.viewmodel

import androidx.lifecycle.ViewModel
import cr.ac.utn.jprovider.domain.model.OrderRequest
import cr.ac.utn.jprovider.domain.model.Provider
import cr.ac.utn.jprovider.domain.repository.IProviderRepository

class ProviderViewModel(

    private val repository: IProviderRepository): ViewModel() {

    // Operaciones proveedores

    fun getProviders(): List<Provider> {
        return repository.getProviders()
    }

    fun saveProvider(provider: Provider) {
        repository.insertProvider(provider)
    }

    fun removeProvider(id: String) {
        repository.deleteProvider(id)
    }

    // Operaciones de solicitud de pedidos
    fun getOrderRequests(): List<OrderRequest> {
        return repository.getOrderRequests()
    }

    fun saveOrderRequest(request: OrderRequest) {
        repository.insertOrderRequest(request)
    }
}
